package ru.job4j.stream;

public class Task {
    private final String name;
    private final long spent;

    public Task(String name, long spent) {
        this.name = name;
        this.spent = spent;
    }

    public String getName() {
        return name;
    }

    public long getSpent() {
        return spent;
    }
}
