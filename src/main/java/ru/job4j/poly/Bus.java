package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Bus is drive");
    }

    @Override
    public void putPassengers(int passengers) {
        System.out.println("Quantity passengers is " + passengers);
    }

    @Override
    public double refuel(double fuel) {
        return 51.5 * fuel;
    }
}
