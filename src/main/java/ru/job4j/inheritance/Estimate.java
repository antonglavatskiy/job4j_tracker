package ru.job4j.inheritance;

public class Estimate {
    private String[] name;
    private int[] quantity;
    private double[] cost;

    public Estimate(String[] name, int[] quantity, double[] cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String[] getName() {
        return name;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public double[] getCost() {
        return cost;
    }
}
