package ru.job4j.oop;

public class Airplane implements Vehicle {
    private String name;

    public Airplane(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " flies into the sky");
    }

    @Override
    public void repair() {
        System.out.println(name + " is repaired in a hangar");
    }
}
