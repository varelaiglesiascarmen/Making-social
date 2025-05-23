package makingSocial;

import makingSocial.view.UserProfile_View.Login;

import javax.swing.*;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
