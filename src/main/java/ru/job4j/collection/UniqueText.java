package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        Set<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        String[] duplicate = duplicateText.split(" ");
        for (String word : duplicate) {
            if (!check.contains(word)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
