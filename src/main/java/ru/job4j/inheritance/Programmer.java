package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String[] progLanguages;

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Programmer(String name, String surname, String education, String birthday, Customer customer) {
        super(name, surname, education, birthday, customer);
    }

    public Programmer(String name, String surname, String education, String birthday, Customer customer, String[] progLanguages) {
        super(name, surname, education, birthday, customer);
        this.progLanguages = progLanguages;
    }

    public String[] getProgLanguages() {
        return progLanguages;
    }

    public void startProject(String[] progLanguages) {

    }
}
