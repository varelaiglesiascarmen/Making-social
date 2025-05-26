package makingSocial.view.UserProfile_View;

import makingSocial.DAO.UserProfileDAO.homePageDAO;
import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.GuestModel_View.profile;
import makingSocial.view.GuestModel_View.searchEvent;
import makingSocial.view.HostModel_View.createEvent;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private userModel currentUser;
    private eventModel currentEvent;

    public homePage(userModel currentUser) {
        this.currentUser = currentUser;
    }

    public homePage(eventModel currentEvent) {
        this.currentEvent = currentEvent;
    }

    public homePage() {
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

                homePageDAO dao = new homePageDAO();
                userModel currentUser = session.getCurrentUser();

                if (dao.searchID_UserInHost(currentUser)) {
                    // Si ya es host, pasa directo
                    createEvent createEvent = new createEvent(currentUser);
                    createEvent.setVisible(true);
                    dispose();
                } else {
                    // Si no es host, lo registramos como host y pasamos igualmente
                    dao.insertHostForUser(currentUser);

                    createEvent createEvent = new createEvent(currentUser);
                    createEvent.setVisible(true);
                    dispose();
                }
            }
        });

        btnAttendEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePageDAO dao = new homePageDAO();
                userModel currentUser2 = session.getCurrentUser();

                if(dao.searchID_UserInGuest(currentUser2)){

                    // llamar a la ventana searchEvent
                    searchEvent searchevent = new searchEvent(currentEvent);
                    searchevent.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();

                }else {
                    // Si no es guest, lo registramos como guest y pasamos igualmente
                    dao.insertGuestForUser(currentUser2);

                    // llamar a la ventana searchEvent
                    searchEvent searchevent = new searchEvent(currentEvent);
                    searchevent.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();
                }
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana profile
                profile img = new profile(currentUser);
                img.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
