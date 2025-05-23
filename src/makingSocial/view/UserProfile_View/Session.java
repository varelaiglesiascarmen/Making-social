package makingSocial.view.UserProfile_View;

import makingSocial.model.UserModel;

public class Session {
    private static UserModel currentUser;

    public static UserModel getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }
}

