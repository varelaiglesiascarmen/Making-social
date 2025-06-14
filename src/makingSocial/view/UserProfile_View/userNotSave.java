package makingSocial.view.UserProfile_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userNotSave extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public userNotSave() {
        setTitle("Making Social! - Error 1017");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 476, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel errorTitleUserNotSave = new JLabel("Error al crear el usuario");
        errorTitleUserNotSave.setFont(new Font("Tahoma", Font.BOLD, 25));
        errorTitleUserNotSave.setBounds(60, 26, 555, 45);
        contentPane.add(errorTitleUserNotSave);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(207, 129, 85, 21);
        contentPane.add(btnOk);

        // al darle a ok se cierra la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JLabel errorTxtUserNotSave = new JLabel("Inténtelo de nuevo.");
        errorTxtUserNotSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
        errorTxtUserNotSave.setBounds(60, 81, 498, 21);
        contentPane.add(errorTxtUserNotSave);
    }
}