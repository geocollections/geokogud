package generator;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static ee.ttu.geocollection.interop.api.deserializer.DeserializerUtils.*;
import static java.util.stream.Collectors.toList;

public class Test {

    public static final String HTTPS_API_ARENDUS_GEOKOGUD_INFO = "https://api.arendus.geokogud.info";
    public static final String AVAILABLE_API_ENDPOINTS_ID = "available-api-endpoints";
    public static final String UL_TAG = "ul";
    public static final String LI_TAG = "li";
    private List<JavaClassSource> generatedClasses = new ArrayList<>();
    private Map<String, List<String>> tableFields = new HashMap<>();

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.getTablesAndFieldsFromApi();
            //test.generateFromTxtFiles();
            test.buildDtos();
            test.writeSources();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getTablesAndFieldsFromApi() throws IOException {
        HttpGet request = new HttpGet(HTTPS_API_ARENDUS_GEOKOGUD_INFO);
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContexts.createDefault(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String apiPageContent = EntityUtils.toString(entity);
        Document htmlContent = Jsoup.parse(apiPageContent);

        Element apiEndpoints = htmlContent
                .getElementById(AVAILABLE_API_ENDPOINTS_ID)
                .getElementsByTag(UL_TAG)
                .get(0);
        for (Element apiEndpoint : apiEndpoints.children()) {
            String rawEndpointData = apiEndpoint.text();
            String tableName = rawEndpointData.substring(0, rawEndpointData.indexOf(":"));
            Elements fields = apiEndpoint
                    .getElementsByTag(UL_TAG).get(0)
                    .getElementsByTag(LI_TAG).get(0)
                    .getElementsByTag(UL_TAG).get(0)
                    .getElementsByTag(LI_TAG);
            List<String> fieldNames = fields.stream()
                    .map(Element::text)
                    .collect(toList());
            tableFields.put(tableName, fieldNames);
        }
    }

    private void buildDtos() throws IOException {
        tableFields.entrySet().forEach(entry -> process(entry.getValue(), entry.getKey()));
    }

    private void generateFromTxtFiles() throws IOException {
        String pathToResources = new File("src/main/resources/tables.txt").getAbsolutePath();
        Stream<String> tables = Files.lines(Paths.get(pathToResources), Charset.defaultCharset());
        tables.forEach(this::buildDtoFromTxtFile);
    }

    private void buildDtoFromTxtFile(String fileName) {
        String pathToResources = new File("src/main/resources/" + fileName + ".txt").getAbsolutePath();
        try {
            List<String> lines = Files.lines(Paths.get(pathToResources), Charset.defaultCharset()).collect(toList());
            tableFields.put(fileName, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JavaClassSource process(List<String> allFields, String rawClass) {
        Set<String> fieldsToIgnore = new HashSet<>();
        String formattedClass = removeUnderscoresCapitalizeMakeCamelCase(rawClass);
        JavaClassSource dto = getJavaClassSource(formattedClass);
        for (String field : allFields) {
            if (isObject(field)) {
                if (fieldsToIgnore.contains(field)) {
                    continue;
                }
                int firstDelimiter = field.indexOf(OBJECT_DELIMITER);
                String objectFieldName = field.substring(0, firstDelimiter);
                String formattedObjectFieldName = StringUtils.uncapitalize(removeUnderscoresCapitalizeMakeCamelCase(objectFieldName) + "Dto");
                if (propertyDoesNotExist(formattedObjectFieldName, dto)) {
                    GeneratorObjectFields generatorObjectFields = findRelatedFieldsAndRemoveObjectPrefix(objectFieldName, allFields);
                    fieldsToIgnore.addAll(generatorObjectFields.getFullFields());

                    JavaClassSource subDto = process(generatorObjectFields.getCutFields(), objectFieldName);
                    dto.addProperty(subDto, formattedObjectFieldName);
                }
            } else {
                field = removeUnderscoresMakeCamelCase(field);
                if (propertyDoesNotExist(field, dto)) {
                    if (isJavaKeyWord(field)) {
                        field += "Field";
                    }
                    dto.addProperty(String.class, field);
                }
            }
        }
        return dto;
    }



    private boolean propertyDoesNotExist(String field, JavaClassSource dto) {
        return dto.getProperty(field) == null;
    }

    private GeneratorObjectFields findRelatedFieldsAndRemoveObjectPrefix(String prefix, List<String> fields) {
        List<String> fullFields = new ArrayList<>();
        List<String> cutFields = new ArrayList<>();
        int prefixLength = prefix.length();
        for (String field : fields) {
            if (field.length() >= prefixLength && field.contains(OBJECT_DELIMITER) && field.substring(0, prefixLength).equals(prefix)) {
                cutFields.add(field.substring(prefixLength + 2));
                fullFields.add(field);
            }
        }
        return new GeneratorObjectFields(fullFields, cutFields);
    }


    private void writeSources() throws IOException {
        String pathToSources = new File("src/main/java/test").getAbsolutePath();
        Path pathToGeneratedSources = Paths.get(pathToSources);
        Files.createDirectories(pathToGeneratedSources);
        for (JavaClassSource generatedClass : generatedClasses) {
            Path file = Paths.get(pathToGeneratedSources.toAbsolutePath().toString(), generatedClass.getName() + ".java");
            Files.write(file, generatedClass.toString().getBytes());
        }
    }


    private JavaClassSource getJavaClassSource(String formattedClass) {
        Optional<JavaClassSource> existingDto = doesDtoExist(formattedClass);
        if (existingDto.isPresent()) {
            return existingDto.get();
        }

        JavaClassSource dto = Roaster.create(JavaClassSource.class);
        generatedClasses.add(dto);
        dto.setPackage("test").setName(formattedClass);
        return dto;
    }

    private Optional<JavaClassSource> doesDtoExist(String formattedClass) {
        return generatedClasses.stream().filter(source -> source.getName().equals(formattedClass)).findFirst();
    }

}
