package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String[] specialization;

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String name, String surname, String education, String birthday, Patient patient) {
        super(name, surname, education, birthday, patient);
    }

    public Surgeon(String name, String surname, String education, String birthday, Patient patient, String[] specialization) {
        super(name, surname, education, birthday, patient);
        this.specialization = specialization;
    }

    public String[] getSpecialization() {
        return specialization;
    }

    public boolean toTreat(Patient patient, String[] specialization) {
        return false;
    }
}
