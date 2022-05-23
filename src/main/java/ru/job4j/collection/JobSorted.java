package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorted {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        Comparator<Job> compAscName = Comparator.comparing(Job::getName);
        Comparator<Job> compAscPriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> combine = compAscName.thenComparing(compAscPriority);
        jobs.sort(combine);
    }
}
