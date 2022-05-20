package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return Integer.compare(Integer.parseInt(first.split(". ")[0]),
                Integer.parseInt(second.split(". ")[0]));
    }
}
