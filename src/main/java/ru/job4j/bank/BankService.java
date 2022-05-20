package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя;
 * 2. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов;
 * 3. Переводить деньги с одного банковского счета на другой счет.
 * @author Anton Glavatskiy
 * @version 1.0
 */
public class BankService {
    /**
     * Все пользователи системы и привязанные к ним счета.
     * хранятся в поле HashMap<User, List<Account>>.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *Метод добавляет пользователя банка в систему.
     * @param user пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый банковский счет существуещему пользователю банка
     * по номеру паспорта.
     * @param passport номер паспорта пользователя банка
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод поиска пользователя банка в системе по номеру паспорта.
     * Если пользователь не найден, метод должен вернуть null.
     * @param passport номер паспорта
     * @return пользователь
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод осуществляет поиск банковского счета по номеру паспорта
     * пользователя и по номеру счета.
     * Если банковский счет или пользователь не найден, метод должен вернуть null.
     * @param passport номер паспорта
     * @param requisite номер счета
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счета на другой.
     * Если счет не найден или не хватает денег на счете отправителя,
     * то метод возвращает false.
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount денежная сумма
     * @return true - успешный перевод; false - неудачный перевод
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
