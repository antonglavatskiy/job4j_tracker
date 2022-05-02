package ru.job4j.inheritance;

public class Customer {
    private String companyName;
    private double budget;

    public Customer(String companyName, double budget) {
        this.companyName = companyName;
        this.budget = budget;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getBudget() {
        return budget;
    }
}
