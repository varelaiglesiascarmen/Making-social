package makingSocial.view.GuestModel_View;

import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private EventModel currentEvent;
    private UserModel currentUser;

    // ✅ Constructor que recibe UserModel (lo usas desde HomePage)
    public Profile(UserModel currentUser) {
        this.currentUser = currentUser;

        // ✅ Añadimos aquí toda la GUI
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            setIconImage(icon.getImage());
        }

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
                HomePage homepage = new HomePage();
                homepage.setVisible(true);
                dispose();
            }
        });

        btnMakingSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attendedEvents eventosAsistidosVentana = new attendedEvents(currentUser);
                eventosAsistidosVentana.setVisible(true);
                dispose();
            }
        });

        // ✅ Mostrar la ventana
        setVisible(true); // <--- Ahora sí aparece
    }

    // Otros constructores que ya tienes (no los modificamos)

    public Profile(EventModel currentEvent) {
        this.currentEvent = currentEvent;
    }

    public Profile() {
        this.currentEvent = currentEvent;
    }
}