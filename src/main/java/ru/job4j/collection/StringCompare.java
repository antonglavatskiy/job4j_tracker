package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int length = Integer.compare(o1.length(), o2.length());
        int rsl = 0;
        if (length > 0) {
            for (int i = 0; i < o2.length(); i++) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
            rsl++;
        } else if (length < 0) {
            for (int i = 0; i < o1.length(); i++) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
            rsl--;
        } else {
            for (int i = 0; i < o1.length(); i++) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
        }
        return rsl;
    }
}
