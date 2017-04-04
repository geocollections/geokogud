package ee.ttu.geocollection.interop.api.deserializer;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class DeserializerUtils {

    public static final String UNDERSCORE = "_";
    public static final String OBJECT_DELIMITER = StringUtils.repeat(UNDERSCORE, 2);

    public static boolean isObject(String field) {
        return field.contains(OBJECT_DELIMITER);
    }

    public static String removeUnderscoresMakeCamelCase(String field) {
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

    public static String removeUnderscoresCapitalizeMakeCamelCase(String objectFieldName) {
        return StringUtils.capitalize(removeUnderscoresMakeCamelCase(objectFieldName));
    }

    public static boolean isJavaKeyWord(String field) {
        return Arrays.asList("abstract", "public").contains(field);
    }
}
