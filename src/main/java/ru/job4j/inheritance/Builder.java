package ru.job4j.inheritance;

public class Builder extends Engineer {
    private Project project;

    public Builder(String name, String surname, String education, String birthday, Customer customer, Project project) {
        super(name, surname, education, birthday, customer);
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public Estimate calculation() {
        return null;
    }
}
