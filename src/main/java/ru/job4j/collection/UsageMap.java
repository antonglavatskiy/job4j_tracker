package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("pochta@mail.ru", "Ivanov P.S.");
        map.put("pochta@yandex.ru", "Ivanov P.S.");
        map.put("pochta@yandex.ru", "Petrov P.S.");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
