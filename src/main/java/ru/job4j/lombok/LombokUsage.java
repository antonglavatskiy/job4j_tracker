package ru.job4j.lombok;

public class LombokUsage {
    public static void main(String[] args) {
        BirdData bird = new BirdData();
        bird.setColor("white");
        bird.setAge(2);
        System.out.println(bird);
    }
}
