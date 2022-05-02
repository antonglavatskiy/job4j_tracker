package ru.job4j.inheritance;

public class Engineer extends Profession {
    private Customer customer;

    public Engineer(String name, String surname, String education, String birthday, Customer customer) {
        super(name, surname, education, birthday);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isWork(Customer customer) {
        return false;
    }
}
