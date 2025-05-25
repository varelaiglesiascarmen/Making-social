package makingSocial.view.UserProfile_View;

import makingSocial.DAO.UserProfile_DAO.HomePage_DAO;
import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.view.GuestModel_View.Profile;
import makingSocial.view.GuestModel_View.SearchEvent;
import makingSocial.view.HostModel_View.CreateEvent;
import makingSocial.model.UserModel;


import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private UserModel currentUser;
    private EventModel currentEvent;

    public HomePage(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    public HomePage(EventModel currentEvent) {
        this.currentEvent = currentEvent;
    }

    public HomePage() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        // Tamaño del botón
        int btnWidth = 383;
        int btnHeight = 185;
        // Coordenadas centradas horizontalmente (mitad de la ventana menos mitad del botón)
        int centerX1 = (960 / 2) - btnWidth - 25; // botón izquierdo
        int centerX2 = (960 / 2) + 25; // botón derecho
        int centerY = 220;

        JButton btnCreateEvent = new JButton("Crear evento");
        btnCreateEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnCreateEvent.setBounds(centerX1, centerY, btnWidth, btnHeight);
        contentPane.add(btnCreateEvent);

        JButton btnAttendEvent = new JButton("Asistir a evento");
        btnAttendEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnAttendEvent.setBounds(centerX2, centerY, btnWidth, btnHeight);
        contentPane.add(btnAttendEvent);

        // Botón de perfil (esquina superior izquierda)
        JButton btnProfile = new JButton("Perfil");
        btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProfile.setBounds(10, 10, 100, 40);
        contentPane.add(btnProfile);

        btnCreateEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HomePage_DAO dao = new HomePage_DAO();
                UserModel currentUser = Session.getCurrentUser();

                if (dao.searchID_UserInHost(currentUser)) {
                    // Si ya es host, pasa directo
                    CreateEvent createEvent = new CreateEvent(currentUser);
                    createEvent.setVisible(true);
                    dispose();
                } else {
                    // Si no es host, lo registramos como host y pasamos igualmente
                    dao.insertHostForUser(currentUser);

                    CreateEvent createEvent = new CreateEvent(currentUser);
                    createEvent.setVisible(true);
                    dispose();
                }
            }
        });

        btnAttendEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage_DAO dao = new HomePage_DAO();
                UserModel currentUser2 = Session.getCurrentUser();

                if(dao.searchID_UserInGuest(currentUser2)){

                    // llamar a la ventana SearchEvent
                    SearchEvent searchevent = new SearchEvent(currentEvent);
                    searchevent.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();

                }else {
                    // Si no es guest, lo registramos como guest y pasamos igualmente
                    dao.insertGuestForUser(currentUser2);

                    // llamar a la ventana SearchEvent
                    SearchEvent searchevent = new SearchEvent(currentEvent);
                    searchevent.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();
                }
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Profile
                Profile img = new Profile(currentUser);
                img.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
