package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String dep : deps) {
            String start = "";
            for (String el : dep.split("/")) {
                temp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
