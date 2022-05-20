package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Anton Glavatskiy
 * @version 1.0
 */
public class Account {
    /**
     *Хранение номера счета осуществляется в поле типа String.
     */
    private String requisite;
    /**
     * Хранение баланса осуществляется в поле типа double.
     */
    private double balance;

    /**
     * Конструктор - создание нового банковского счета.
     * @param requisite - номер счета
     * @param balance - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получение номера банковского счета.
     * @return номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Установка значения номера банковского счета.
     * @param requisite номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получение значения баланса банковского счета.
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Установка значения баланса банковского счета.
     * @param balance баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнения банковских счетов по значению номера счета.
     * @param o другой банковский счет
     * @return результат сравнения true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод получения уникального номера банковского счета.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
