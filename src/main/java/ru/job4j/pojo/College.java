package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student ivanov = new Student();
        ivanov.setName("Иванов И.П.");
        ivanov.setGroup(113);
        ivanov.setAdmissionDate(new Date());
        System.out.println("Студент " + ivanov.getName() + " поступил в группу № " + ivanov.getGroup() + " "
                            + ivanov.getAdmissionDate());
    }
}
