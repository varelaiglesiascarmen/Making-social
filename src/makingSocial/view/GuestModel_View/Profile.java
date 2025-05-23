package makingSocial.view.GuestModel_View;

import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public Profile() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnMakingSocial = new JButton("Making Social!");
        btnMakingSocial.setFont(new Font("Tahoma", Font.PLAIN, 40));
        btnMakingSocial.setBounds(228, 242, 518, 160);
        contentPane.add(btnMakingSocial);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel currentUser = Session.getCurrentUser();

                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnMakingSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Profile
                Profile prfl = new Profile();
                prfl.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
