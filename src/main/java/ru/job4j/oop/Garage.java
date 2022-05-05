package ru.job4j.oop;

public class Garage {
    public static void main(String[] args) {
        Vehicle boeing = new Airplane("Boeing");
        Vehicle superjet = new Airplane("Superjet");
        Vehicle mercedes = new Bus("Mercedes");
        Vehicle ssangyong = new Bus("Ssangyong");
        Vehicle electro = new Train("Electro");
        Vehicle diesel = new Train("Diesel");
        Vehicle[] vehicles = new Vehicle[]{superjet, mercedes, ssangyong, electro, boeing, diesel};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.repair();
        }
    }
}
