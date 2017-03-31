package ee.ttu.geodeesia.interop.api.deserializer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * it will detect objects by double underscore __
 * it will convert value_en to valueEn in class
 * will I need to make it recursive ?
 * POJOs are required to have setters (?)
 */
@Component
public class Deserializer {

    private static final Logger logger = LoggerFactory.getLogger(Deserializer.class);

    private static final String UNDERSCORE = "_";
    private static final String OBJECT_DELIMITER = StringUtils.repeat(UNDERSCORE, 2);

    public <T> T doMagic(Map<String, String> map, Class<T> targeClass) {
        try {
            Set<String> fieldsToIgnore = new HashSet<>();
            T instance = targeClass.newInstance();
            for (Map.Entry<String, String> fieldValue : map.entrySet()) {
                String field = fieldValue.getKey();
                String value = fieldValue.getValue();
                if (value == null) {
                    continue;
                }
                if (isObject(field)) {
                    if (fieldsToIgnore.contains(field)) {
                        continue;
                    }
                    int firstDelimiter = field.indexOf(OBJECT_DELIMITER);
                    String objectFieldName = field.substring(0, firstDelimiter);
                    String formattedObjectFieldName = removeUnderscoresMakeCamelCase(objectFieldName);
                    try {
                        Class<?> objectFieldClass = findObjectFieldClass(targeClass, formattedObjectFieldName);
                        ObjectFields objectFields = findRelatedFieldsAndRemoveObjectPrefix(objectFieldName, map);
                        fieldsToIgnore.addAll(objectFields.getFullFields());
                        Object newObject = doMagic(objectFields.getCutFields(), objectFieldClass);

                        BeanUtils.setProperty(instance, formattedObjectFieldName, newObject);
                    } catch (NoSuchFieldException e) {
                        traceFieldDoesNotExist(targeClass, formattedObjectFieldName);
                        continue;
                    }
                } else {
                    field = removeUnderscoresMakeCamelCase(field);
                    try {
                        targeClass.getDeclaredField(field);
                    } catch (NoSuchFieldException e) {
                        traceFieldDoesNotExist(targeClass, field);
                        continue;
                    }
                    BeanUtils.setProperty(instance, field, value);
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> void traceFieldDoesNotExist(Class<T> targeClass, String field) {
        logger.trace(targeClass.getTypeName()+": field " + field + " does not exist");
    }

    private <T> Class<?> findObjectFieldClass(Class<T> targeClass, String objectName) throws NoSuchFieldException {
        Field objectField = targeClass.getDeclaredField(objectName);
        return objectField.getType();
    }

    private ObjectFields findRelatedFieldsAndRemoveObjectPrefix(String prefix, Map<String, String> fieldValues) {
        Set<String> fullFields = new HashSet<>();
        Map<String, String> cutFields = new HashMap<>();
        int prefixLength = prefix.length();
        for (Map.Entry<String, String> fieldValue : fieldValues.entrySet()) {
            String field = fieldValue.getKey();
            if (field.length() >= prefixLength && field.substring(0, prefixLength).equals(prefix)) {
                cutFields.put(field.substring(prefixLength + 2), fieldValue.getValue());
                fullFields.add(field);
            }
        }
        return new ObjectFields(fullFields, cutFields);
    }

    private String removeUnderscoresMakeCamelCase(String field) {
        int underscorePosition = field.indexOf(UNDERSCORE);
        if (underscorePosition > -1) {
            StringBuilder result = new StringBuilder(field);
            while (underscorePosition >= 0) {
                char nextChar = result.charAt(underscorePosition + 1);
                String nextCharUpperCase = Character.toString(Character.toUpperCase(nextChar));
                result.replace(underscorePosition, underscorePosition + 2, nextCharUpperCase);
                underscorePosition = result.indexOf(UNDERSCORE);
            }
            return result.toString();
        }
        return field;
    }

    private boolean isObject(String field) {
        return field.contains(OBJECT_DELIMITER);
    }

    private class ObjectFields {
        private Set<String> fullFields = new HashSet<>();
        private Map<String, String> cutFields = new HashMap<>();

        private ObjectFields(Set<String> fullFields, Map<String, String> cutFields) {
            this.fullFields = fullFields;
            this.cutFields = cutFields;
        }

        public Set<String> getFullFields() {
            return fullFields;
        }

        private Map<String, String> getCutFields() {
            return cutFields;
        }
    }
}