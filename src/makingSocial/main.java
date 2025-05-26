package makingSocial;

import makingSocial.view.UserProfile_View.login;

import javax.swing.*;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new login().setVisible(true);
        });

    }
}
