package ru.job4j.oop;

public class Train implements Vehicle {
    private String name;

    public Train(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " moving on rails");
    }

    @Override
    public void repair() {
        System.out.println(name + " is repaired at the depot");
    }
}
