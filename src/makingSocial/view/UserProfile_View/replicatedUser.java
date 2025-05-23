package makingSocial.view.UserProfile_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class replicatedUser extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public replicatedUser() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel errorTitle = new JLabel("Usuario ya existe");
        errorTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        errorTitle.setBounds(45, 26, 377, 45);
        contentPane.add(errorTitle);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(197, 128, 85, 21);
        contentPane.add(btnOk);

        JLabel errorTxt = new JLabel("Por favor, ve a iniciar sesión");
        errorTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        errorTxt.setBounds(45, 81, 377, 21);
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
