package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgumentLessZero() {
        Fact.calc(-5);
    }

    @Test
    public void whenArgumentMoreZero() {
        int expected = 120;
        int result = Fact.calc(5);
        Assert.assertEquals(expected, result);
    }
}