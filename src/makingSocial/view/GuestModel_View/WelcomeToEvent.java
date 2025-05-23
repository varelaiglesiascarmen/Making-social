package makingSocial.view.GuestModel_View;

import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeToEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public WelcomeToEvent() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel notFoundCodeTitle = new JLabel("¡Bienvenido al evento!");
        notFoundCodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        notFoundCodeTitle.setBounds(26, 26, 555, 45);
        contentPane.add(notFoundCodeTitle);

        JLabel notFoundCodeTxt = new JLabel("Desde tu perfil podrás acceder a la búsqueda de \n"+" perfiles 24 horas despues de que éste comience");
        notFoundCodeTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        notFoundCodeTxt.setBounds(36, 81, 631, 21);
        contentPane.add(notFoundCodeTxt);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        // al darle a ok se cierra la ventana
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
    }

}
