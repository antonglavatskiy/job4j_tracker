package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.name + " ate " + this.food + ".");
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("a cutlet");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
