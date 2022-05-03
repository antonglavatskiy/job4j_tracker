package ru.job4j.pojo;

public class Book {
    private String title;
    private int count;

    public Book(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }
}
