package ee.ttu.geodeesia.interop.api.deserializer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * it will detect objects by double underscore __
 * it will convert value_en to valueEn in class
 * will I need to make it recursive ?
 * POJOs are required to have setters (?)
 */
@Component
public class Deserializer {

    private static final String UNDERSCORE = "_";
    private static final String OBJECT_DELIMITER = StringUtils.repeat(UNDERSCORE, 2);
    public static final String NULL = "null";

    public <T> T doMagic(Map<String, String> map, Class<T> targeClass) {
        try {
            T instance = targeClass.newInstance();
            for (Map.Entry<String, String> fieldValue : map.entrySet()) {
                String field = fieldValue.getKey();
                String value = fieldValue.getValue();
                if(value == null){
                    continue;
                }
                if (isObject(field)) {
                    //create object
                    int firstDelimiter = field.indexOf(OBJECT_DELIMITER);
                    String objectFieldName = field.substring(0, firstDelimiter);
                    Class<?> objectFieldClass = findObjectFieldClass(targeClass, objectFieldName);
                    Map<String, String> objectRelatedFields = findRelatedFieldsAndRemoveObjectPrefix(objectFieldName, map);
                    Object newObject = doMagic(objectRelatedFields, objectFieldClass);

                    BeanUtils.setProperty(instance, objectFieldName, newObject);
                } else {
                    field = removeUnderscoresMakeCammelCase(field);
                    BeanUtils.setProperty(instance, field, value);
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> Class<?> findObjectFieldClass(Class<T> targeClass, String objectName) throws NoSuchFieldException {
        Field objectField = targeClass.getField(objectName);
        return objectField.getDeclaringClass();
    }

    private Map<String, String> findRelatedFieldsAndRemoveObjectPrefix(String prefix, Map<String, String> fieldValues) {
        Map<String, String> result = new HashMap<>();
        int prefixLength = prefix.length();
        for (Map.Entry<String, String> fieldValue : fieldValues.entrySet()) {
            String field = fieldValue.getKey();
            if (field.substring(0, prefixLength).equals(prefix)) {
                result.put(field.substring(prefixLength + 2), fieldValue.getValue());
            }
        }
        return result;
    }

    private String removeUnderscoresMakeCammelCase(String field) {
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
}