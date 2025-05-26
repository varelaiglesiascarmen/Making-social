package makingSocial.view.UserProfile_View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class notRegistered extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public notRegistered() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 476, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel errorTitle = new JLabel("Cuenta incorrecta o no existente");
        errorTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        errorTitle.setBounds(26, 26, 555, 45);
        contentPane.add(errorTitle);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(170, 129, 85, 21);
        contentPane.add(btnOk);

        JLabel errorTxt = new JLabel("Si no tienes cuenta, por favor regístrate.");
        errorTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        errorTxt.setBounds(36, 81, 498, 21);
        contentPane.add(errorTxt);

        // al darle a ok se cierra la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
