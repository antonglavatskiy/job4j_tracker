package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(new Job("Go", 4), new Job("Study", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(new Job("Go", 4), new Job("Study", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByNameLn() {
        Comparator<Job> comparator = new JobDescByNameLn();
        int rsl = comparator.compare(new Job("Go", 4), new Job("Study", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(new Job("Go", 4), new Job("Study", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByNameLnAndAscByPriority() {
        Comparator<Job> comparator = new JobDescByNameLn().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(new Job("Go", 4), new Job("Do", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByNameLnAndDescByPriority() {
        Comparator<Job> comparator = new JobDescByNameLn().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(new Job("Go", 4), new Job("Do", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriorityAndAscByName() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = comparator.compare(new Job("Study", 4), new Job("Wait", 2));
        assertThat(rsl, greaterThan(0));
    }

}