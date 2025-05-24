package makingSocial.model;

public class Session {
    private static UserModel currentUser;

    public static UserModel getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }

    private static EventModel currentEvent;

    public static EventModel getcurrentEvent() {
        return currentEvent;
    }

    public static void setCurrentUser(EventModel event) {
        currentEvent = event;
    }
}

