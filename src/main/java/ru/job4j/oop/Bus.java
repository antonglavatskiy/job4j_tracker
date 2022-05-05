package ru.job4j.oop;

public class Bus implements Vehicle {
    private String name;

    public Bus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " is driving on the highway");
    }

    @Override
    public void repair() {
        System.out.println(name + " is repaired in a repair shop");
    }
}
