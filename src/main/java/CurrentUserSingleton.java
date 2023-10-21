public class CurrentUserSingleton {
    private static CurrentUserSingleton instance;
    private Individual currentUser;

    private CurrentUserSingleton() {
        // Private constructor to prevent external instantiation
    }

    public static CurrentUserSingleton getInstance() {
        if (instance == null) {
            instance = new CurrentUserSingleton();
        }
        return instance;
    }

    public Individual getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Individual user) {
        this.currentUser = user;
    }
}
