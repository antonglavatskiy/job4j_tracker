package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ItemAscByNameTest {

    @Test
    public void ascendingByName() {
        Item item1 = new Item(1, "Hello");
        Item item3 = new Item(3, "Simple");
        Item item10 = new Item(10, "Current");
        Item item5 = new Item(5, "Temporary");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item3);
        items.add(item10);
        items.add(item5);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(item10);
        expected.add(item1);
        expected.add(item3);
        expected.add(item5);
        assertThat(items, is(expected));
    }
}