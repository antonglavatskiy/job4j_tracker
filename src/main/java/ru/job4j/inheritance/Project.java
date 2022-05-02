package ru.job4j.inheritance;

import java.util.Date;

public class Project {
    private String[] tasks;
    private Date timeOver;

    public Project(String[] tasks, Date timeOver) {
        this.tasks = tasks;
        this.timeOver = timeOver;
    }

    public String[] getTasks() {
        return tasks;
    }

    public Date getTimeOver() {
        return timeOver;
    }
}
