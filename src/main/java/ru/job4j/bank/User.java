package ru.job4j.bank;

import java.util.Objects;

/**
 *Класс описывает модель пользователя банка
 * @author Anton Glavatskiy
 * @version 1.0
 */
public class User {
    /**
     *Хранение номера паспорта осуществляется в поле типа String.
     */
    private String passport;
    /**
     *Хранение имени(ФИО) пользователя осуществляется в поле типа String.
     */
    private String username;

    /**
     * Конструктор - создание нового пользователя банка.
     * @param passport паспорт
     * @param username имя(ФИО)
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получение номера паспорта пользователя банка.
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Установка значения номера паспорта пользователя банка.
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получение имени(ФИО) пользователя банка.
     * @return имя(ФИО)
     */
    public String getUsername() {
        return username;
    }

    /**
     * Присваивание имени(ФИО) пользователю банка.
     * @param username имя(ФИО)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнения пользователей банка по значению номера паспорта.
     * @param o другой пользователь банка
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод получения уникального номера пользователя банка.
     * по номеру паспорта
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
