package makingSocial.view.UserProfile_View;

import makingSocial.DAO.UserProfile_DAO.Login_DAO;
import makingSocial.model.UserModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

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

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

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
        Font font = lblRegister.getFont();
        Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblRegister.setFont(font.deriveFont(attributes));

        // Puntero override
        lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SigIn signInFrame = new SigIn();
                signInFrame.setVisible(true);
                signInFrame.setLocationRelativeTo(null);
                dispose(); // opcional: cierra el login si quieres
            }
        });

        contentPane.add(lblRegister, gbc);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Preguntar si usuario y contraseña existe
                String NickName = usernameField.getText();
                String Password = new String(passwordField.getPassword());

                // Crear el objeto del modelo
                UserModel usuario = new UserModel(NickName, Password);

                // get.NickName & get.Password == true?
                boolean insert = false;
                insert = new Login_DAO().ejecutarSelect(usuario);

                // si el usuario existe, le manda a homepage
                if(insert == true){
                    // llamar a la ventana Homepage
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();
                }
                // si el usuario no existe, le dice q se registre
                else {
                    notRegistered notRegistered = new notRegistered();
                    notRegistered.setVisible(true);
                }
            }
        });
    }
}
