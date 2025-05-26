package makingSocial.model;

public class session {
    private static userModel currentUser;

    public static userModel getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(userModel user) {
        currentUser = user;
    }

    private static eventModel currentEvent;

    public static eventModel getcurrentEvent() {
        return currentEvent;
    }

    public static void setcurrentEvent(eventModel currentEvent) {
        session.currentEvent = currentEvent;
    }

    public static void setCurrentUser(eventModel event) {
        currentEvent = event;
    }

    private static guestModel currentGuest;

    public static guestModel getCurrentGuest() {
        return currentGuest;
    }

    public static void setCurrentGuest(guestModel guest) {
        currentGuest = guest;
    }
}

