package makingSocial.controller;

import java.util.*;

public class MatchManager {
    private static final List<Integer> shownUsers = new ArrayList<>();

    public static void addShownUser(int userId) {
        if (!shownUsers.contains(userId)) {
            shownUsers.add(userId);
        }
    }

    public static boolean hasShown(int userId) {
        return shownUsers.contains(userId);
    }

    public static void reset() {
        shownUsers.clear();
    }
}
