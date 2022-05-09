package ru.job4j.ex;

public class User {
    private String userName;
    private boolean valid;

    public User(String name, boolean valid) {
        this.userName = name;
        this.valid = valid;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isValid() {
        return valid;
    }
}
