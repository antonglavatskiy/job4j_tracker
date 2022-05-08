package ru.job4j.ex;

import org.junit.Test;

public class CountTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartGreaterThenFinish() {
        Count.add(12, 2);
    }
}