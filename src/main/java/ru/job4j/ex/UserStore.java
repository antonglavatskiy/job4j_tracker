package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User currentUser : users) {
            if (login.equals(currentUser.getUserName())) {
                user = currentUser;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User \"" + login + "\" not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUserName().length() < 3) {
            throw new UserInvalidException("User \"" + user.getUserName() + "\" is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Ivanov", true), new User("Petrov", false),
                        new User("Li", true), new User("Sidorov", true),
                        new User("Jo", false)
        };
        try {
            User user = findUser(users, "Petrovich");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("This user is invalid");
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            System.out.println("This user not found");
            unf.printStackTrace();
        }
    }
}
