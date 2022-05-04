package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int indexResult = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                result[indexResult] = items[index];
                indexResult++;
            }
        }
        result = Arrays.copyOf(result, indexResult);
        return result;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int indexResult = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && key.equals(items[index].getName())) {
                result[indexResult] = items[index];
                indexResult++;
            }
        }
        result = Arrays.copyOf(result, indexResult);
        return result;
    }
}