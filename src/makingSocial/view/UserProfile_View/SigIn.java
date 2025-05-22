package makingSocial.view.UserProfile_View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import makingSocial.DAO.UserProfile_DAO.SignIn_DAO;
import makingSocial.model.UserModel;
import makingSocial.view.HostModel_View.notAllNodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SigIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldEMAil;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldConfirm;
    private JTextField textField;
    private JTextField textFieldAge;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SigIn frame = new SigIn();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SigIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel SignInTitle = new JLabel("Registrate");
        SignInTitle.setHorizontalAlignment(SwingConstants.CENTER);
        SignInTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        SignInTitle.setBounds(246, 80, 415, 74);
        contentPane.add(SignInTitle);

        JLabel Name = new JLabel("Nombre");
        Name.setHorizontalAlignment(SwingConstants.RIGHT);
        Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Name.setBounds(246, 196, 181, 37);
        contentPane.add(Name);

        JLabel Password = new JLabel("Contraseña");
        Password.setHorizontalAlignment(SwingConstants.RIGHT);
        Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Password.setBounds(246, 243, 181, 37);
        contentPane.add(Password);

        JLabel PassWordConfirm = new JLabel("Confirmar contraseña");
        PassWordConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
        PassWordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
        PassWordConfirm.setBounds(192, 290, 235, 37);
        contentPane.add(PassWordConfirm);

        JLabel E_Mail = new JLabel("e-mail");
        E_Mail.setHorizontalAlignment(SwingConstants.RIGHT);
        E_Mail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        E_Mail.setBounds(246, 337, 181, 37);
        contentPane.add(E_Mail);

        JLabel Age = new JLabel("Edad");
        Age.setHorizontalAlignment(SwingConstants.RIGHT);
        Age.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Age.setBounds(246, 384, 181, 37);
        contentPane.add(Age);

        textFieldName = new JTextField();
        textFieldName.setBounds(437, 196, 181, 37);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldEMAil = new JTextField();
        textFieldEMAil.setColumns(10);
        textFieldEMAil.setBounds(437, 337, 181, 37);
        contentPane.add(textFieldEMAil);

        passwordField = new JPasswordField();
        passwordField.setBounds(437, 243, 181, 37);
        contentPane.add(passwordField);

        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setBounds(437, 290, 181, 37);
        contentPane.add(passwordFieldConfirm);

        JButton btnOK = new JButton("Confirmar");
        btnOK.setBounds(387, 461, 140, 29);
        contentPane.add(btnOK);

        JLabel NickName = new JLabel("Nombre usuario");
        NickName.setHorizontalAlignment(SwingConstants.RIGHT);
        NickName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NickName.setBounds(246, 149, 181, 37);
        contentPane.add(NickName);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(437, 149, 181, 37);
        contentPane.add(textField);

        textFieldAge = new JTextField();
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(437, 384, 181, 37);
        contentPane.add(textFieldAge);

        btnOK.addActionListener(new ActionListener() {
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
                insert = new SignIn_DAO().ejecutarInsertDeleteUpdate(usuario);

                // si el usuario se ha guardado bien, le manda a homepage
                if(insert == true){
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
        });

        JButton btnGoHomePage = new JButton("Iniciar sesión");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Homepage
                Login Login = new Login();
                Login.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
