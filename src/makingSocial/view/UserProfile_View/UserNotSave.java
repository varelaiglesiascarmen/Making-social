package makingSocial.view.UserProfile_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserNotSave extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserNotSave frame = new UserNotSave();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserNotSave() {
        setTitle("Making Social! - Error 1017");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 476, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel errorTitleUserNotSave = new JLabel("Error al crear el usuario");
        errorTitleUserNotSave.setFont(new Font("Tahoma", Font.BOLD, 25));
        errorTitleUserNotSave.setBounds(60, 26, 555, 45);
        contentPane.add(errorTitleUserNotSave);


        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(207, 129, 85, 21);
        contentPane.add(btnOk);

        JLabel errorTxtUserNotSave = new JLabel("Inténtelo de nuevo.");
        errorTxtUserNotSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
        errorTxtUserNotSave.setBounds(60, 81, 498, 21);
        contentPane.add(errorTxtUserNotSave);
    }
}