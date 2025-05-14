package makingSocial.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SigIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNickName;
    private JTextField textFieldEMAil;
    private JPasswordField passwordField;
    private JPasswordField passwordFieldConfirm;

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public SigIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel SignInTitle = new JLabel("Registrate");
        SignInTitle.setHorizontalAlignment(SwingConstants.CENTER);
        SignInTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        SignInTitle.setBounds(246, 80, 415, 74);
        contentPane.add(SignInTitle);

        JLabel NickName = new JLabel("Nombre usuario");
        NickName.setHorizontalAlignment(SwingConstants.RIGHT);
        NickName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NickName.setBounds(246, 196, 181, 37);
        contentPane.add(NickName);

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

        JLabel e_Mail = new JLabel("e-mail");
        e_Mail.setHorizontalAlignment(SwingConstants.RIGHT);
        e_Mail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        e_Mail.setBounds(246, 337, 181, 37);
        contentPane.add(e_Mail);

        JLabel Age = new JLabel("Edad");
        Age.setHorizontalAlignment(SwingConstants.RIGHT);
        Age.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Age.setBounds(246, 384, 181, 37);
        contentPane.add(Age);

        textFieldNickName = new JTextField();
        textFieldNickName.setBounds(437, 196, 181, 37);
        contentPane.add(textFieldNickName);
        textFieldNickName.setColumns(10);

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

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(437, 384, 181, 37);
        contentPane.add(dateChooser);

        JButton btnOK = new JButton("Confirmar");
        btnOK.setBounds(387, 461, 140, 29);
        contentPane.add(btnOK);
    }
}
