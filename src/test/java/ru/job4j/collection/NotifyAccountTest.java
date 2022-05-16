package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void whenListHasAllUniqueAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenListHasNotUniqueAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("6500", "Pushkin", "ery234"),
                new Account("6501", "Petr", "000001"),
                new Account("6500", "Pushkin", "1313"),
                new Account("6502", "Alexander", "ret21"),
                new Account("6501", "Petr", "000002")

        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("6500", "Pushkin", "ery234"),
                        new Account("6501", "Petr", "000001"),
                        new Account("6502", "Alexander", "ret21")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}