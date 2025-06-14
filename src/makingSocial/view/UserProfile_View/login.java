package makingSocial.view.UserProfile_View;

import makingSocial.DAO.UserProfileDAO.loginDAO;
import makingSocial.model.session;
import makingSocial.model.userModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;

    public login() {
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
                singIn signInFrame = new singIn();
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
                userModel currentUser = new userModel(NickName, Password);

                // get.NickName & get.Password == true?
                userModel dataUser = loginDAO.getCurrentUser(currentUser);

                // si el usuario no existe, le manda a singin
                if(dataUser == null){
                    notRegistered notRegistered = new notRegistered();
                    notRegistered.setVisible(true);
                }
                // si el usuario existe, le manda a homepage
                else {
                    // Guardar usuario en sesión global
                    session.setCurrentUser(dataUser);

                    // llamar a la ventana Homepage
                    homePage homePage = new homePage();
                    homePage.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();

                    /*
                    *
                    * para llamar el usuario logeado en todas las ventanas se pone:
                    *
                    *       userModel loggedUser = session.getCurrentUser();
                    *
                    * */
                }
            }
        });
    }
}
