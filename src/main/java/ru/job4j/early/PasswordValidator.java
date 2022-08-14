package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Enter your password");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s length less than 8 or more than 32 characters",
                            password
                    )
            );
        }
        String temp = password.toLowerCase();
        int countDigit = 0;
        int countSpec = 0;
        if (temp.equals(password)) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s does not contain uppercase characters",
                            password
                    )
            );
        }
        if (temp.toUpperCase().equals(password)) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s does not contain lowercase characters",
                            password
                    )
            );
        }
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                countDigit++;
            }
            if (!Character.isLetterOrDigit(ch)) {
                countSpec++;
            }
        }
        if (countDigit == 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s does not contain digit characters",
                            password
                    )
            );
        }
        if (countSpec == 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s does not contain special characters",
                            password
                    )
            );
        }
        if (temp.contains("qwerty")) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s contains qwerty",
                            password
                    )
            );
        }
        if (temp.contains("12345")) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s contains 12345",
                            password
                    )
            );
        }
        if (temp.contains("password")) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s contains password",
                            password
                    )
            );
        }
        if (temp.contains("admin")) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s contains admin",
                            password
                    )
            );
        }
        if (temp.contains("user")) {
            throw new IllegalArgumentException(
                    String.format(
                            "%s contains user",
                            password
                    )
            );
        }
        return password;
    }
}
