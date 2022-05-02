package ru.job4j.inheritance;

public class Patient {
    private String name;
    private String surname;
    private int age;
    private String disease;
    private String diagnosis;

    public Patient(String name, String surname, int age, String disease, String diagnosis) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.disease = disease;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
