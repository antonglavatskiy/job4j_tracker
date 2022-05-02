package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {
    private Date[] weeklyWorkSchedule;

    public Dentist(String name, String surname, String education, String birthday, Patient patient, Date[] weeklyWorkSchedule) {
        super(name, surname, education, birthday, patient);
        this.weeklyWorkSchedule = weeklyWorkSchedule;
    }

    public Date[] getWeeklyWorkSchedule() {
        return weeklyWorkSchedule;
    }

    public Date makeAnAppointment(Date[] schedule) {
        return null;
    }
}
