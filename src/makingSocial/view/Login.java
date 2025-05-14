package makingSocial.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 700);
        setLocationRelativeTo(null); // Centrar ventana en pantalla

        contentPane = new JPanel(new GridBagLayout()); // usar GridBagLayout
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblTitle = new JLabel("Iniciar sesión", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lblTitle, gbc);

        gbc.gridy++;
        JFormattedTextField usernameField = new JFormattedTextField();
        usernameField.setPreferredSize(new Dimension(200, 34));
        contentPane.add(usernameField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 34));
        contentPane.add(passwordField, gbc);

        gbc.gridy++;
        JButton btnLogin = new JButton("Entrar");
        btnLogin.setPreferredSize(new Dimension(140, 34));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción de login
            }
        });
        contentPane.add(btnLogin, gbc);

        gbc.gridy++;
        JLabel lblRegister = new JLabel("Regístrate aquí", SwingConstants.CENTER);
        lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblRegister, gbc);
    }
}
