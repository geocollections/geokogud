package ee.ttu.geocollection.interop.api.deserializer;

import ee.ttu.geocollection.interop.api.builder.DeserializeObjectFields;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ee.ttu.geocollection.interop.api.deserializer.DeserializerUtils.*;

/**
 * it will detect objects by double underscore __
 * it will convert value_en to valueEn in class
 * POJOs are required to have setters
 */
@Component
public class Deserializer {

    private static final Logger logger = LoggerFactory.getLogger(Deserializer.class);


    public <T> T doMagic(Map<String, String> map, Class<T> targetClass) {
        try {
            Set<String> fieldsToIgnore = new HashSet<>();
            T instance = targetClass.newInstance();
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
                    String formattedObjectFieldName = removeUnderscoresMakeCamelCase(objectFieldName)+"Dto";
                    try {
                        Class<?> objectFieldClass = findObjectFieldClass(targetClass, formattedObjectFieldName);
                        DeserializeObjectFields deserializeObjectFields = findRelatedFieldsAndRemoveObjectPrefix(objectFieldName, map);
                        fieldsToIgnore.addAll(deserializeObjectFields.getFullFields());
                        Object newObject = doMagic(deserializeObjectFields.getCutFields(), objectFieldClass);

                        BeanUtils.setProperty(instance, formattedObjectFieldName, newObject);
                    } catch (NoSuchFieldException e) {
                        traceFieldDoesNotExist(targetClass, formattedObjectFieldName);
                        continue;
                    }
                } else {
                    field = removeUnderscoresMakeCamelCase(field);
                    if(isJavaKeyWord(field)){
                        field += "Field";
                    }
                    try {
                        targetClass.getDeclaredField(field);
                    } catch (NoSuchFieldException e) {
                        traceFieldDoesNotExist(targetClass, field);
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

    private <T> void traceFieldDoesNotExist(Class<T> targetClass, String field) {
        logger.trace(targetClass.getTypeName() + ": field " + field + " does not exist");
    }

    private <T> Class<?> findObjectFieldClass(Class<T> targetClass, String objectName) throws NoSuchFieldException {
        Field objectField = targetClass.getDeclaredField(objectName);
        return objectField.getType();
    }

    private DeserializeObjectFields findRelatedFieldsAndRemoveObjectPrefix(String prefix, Map<String, String> fieldValues) {
        Set<String> fullFields = new HashSet<>();
        Map<String, String> cutFields = new HashMap<>();
        int prefixLength = prefix.length();
        for (Map.Entry<String, String> fieldValue : fieldValues.entrySet()) {
            String field = fieldValue.getKey();
            if (field.length() >= prefixLength && field.contains(OBJECT_DELIMITER) && field.substring(0, prefixLength).equals(prefix)) {
                cutFields.put(field.substring(prefixLength + 2), fieldValue.getValue());
                fullFields.add(field);
            }
        }
        return new DeserializeObjectFields(fullFields, cutFields);
    }

}