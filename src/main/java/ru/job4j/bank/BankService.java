package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.get(user) == null) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> list = users.get(user);
        for (Account account : list) {
            if (requisite.equals(account.getRequisite())) {
                result = account;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(srcPassport, srcRequisite) != null
                && findByRequisite(destPassport, destRequisite) != null
                && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            double src = findByRequisite(srcPassport, srcRequisite).getBalance() - amount;
            double dest = findByRequisite(destPassport, destRequisite).getBalance() + amount;
            findByRequisite(srcPassport, srcRequisite).setBalance(src);
            findByRequisite(destPassport, destRequisite).setBalance(dest);
            rsl = true;
        }
        return rsl;
    }
}
