package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenHasNotDuplicateCitizen() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenHasDuplicateCitizen() {
        Citizen petr1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen petr2 = new Citizen("2f44a", "Petr Sergeevich");
        PassportOffice office = new PassportOffice();
        office.add(petr1);
        boolean expected = office.add(petr2);
        Assert.assertFalse(expected);
    }
}