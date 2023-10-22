package main.java;

public class CurrentUserSingleton {
    private static CurrentUserSingleton instance;
    private User currentUser;

    private CurrentUserSingleton() {
        // Private constructor to prevent external instantiation
    }

    public static CurrentUserSingleton getInstance() {
        if (instance == null) {
            instance = new CurrentUserSingleton();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
