package br.com.felipegabriel.expensetrackerapi.util;

import java.util.Arrays;

public class StringsUtil {

    public static String kebabToCamelCase(String string) {
        String[] parts = string.split("-");
        StringBuilder camelCaseString = new StringBuilder();
        Arrays.stream(parts).forEach(p -> camelCaseString.append(firstLetterToUpperCase(p)));
        return firstLetterToLowerCase(camelCaseString.toString());
    }

    public static String firstLetterToUpperCase(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String firstLetterToLowerCase(String string) {
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }
}
