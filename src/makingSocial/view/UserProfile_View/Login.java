package makingSocial.view.UserProfile_View;

import makingSocial.DAO.UserProfile_DAO.SignIn_DAO;
import makingSocial.model.UserModel;

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


        /* btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuidado: los JPasswordField devuelven char[], hay que convertirlos
                String NickName = textField.getText(); // Corregido: textField contiene el nombre de usuario
                String Password = new String(passwordField.getPassword());
                String PasswordConfirm = new String(passwordFieldConfirm.getPassword());
                String E_Mail = textFieldEMAil.getText();
                int Age = Integer.parseInt(textFieldAge.getText());
                String Name = textFieldName.getText();

                // Crear el objeto del modelo
                UserModel usuario = new UserModel(NickName, Password, PasswordConfirm, E_Mail, Age, Name);

                // Pasa el objeto usuario con sus datos
                boolean insert = false;
                insert = new Login_DAO().ejecutarInsertDeleteUpdate(usuario);

                // si el usuario se ha guardado bien, le manda a homepage
                if( insert == true){
                    // llamar a la ventana Homepage
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();
                }
                // Si no, vuelve a decirle que rellene el formulario
                else {
                    replicatedUser replicatedUser = new replicatedUser();
                    replicatedUser.setVisible(true);
                }
            }
        });*/
    }
}
