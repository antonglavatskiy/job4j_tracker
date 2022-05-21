package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int rsl = second.split("/")[0].compareTo(first.split("/")[0]);
        if (rsl == 0) {
            rsl = first.compareTo(second);
        }
        return rsl;
    }
}
