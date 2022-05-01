package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(2, 0);
        double excepted = 2;
        double result = pointA.distance(pointB);
        Assert.assertEquals(excepted, result, 0.01);
    }

    @Test
    public void when25to10then5dot09() {
        Point pointA = new Point(2, 5);
        Point pointB = new Point(1, 0);
        double excepted = 5.09;
        double result = pointA.distance(pointB);
        Assert.assertEquals(excepted, result, 0.01);
    }
}