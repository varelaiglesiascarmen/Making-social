package makingSocial.view.GuestModel_View;

import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private eventModel currentEvent;

    public searchEvent(eventModel currentEvent) {
        this.currentEvent = currentEvent;
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

        // solo pueden salir los públicos
        JButton btnSearchEvent = new JButton("Buscar evento");
        btnSearchEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnSearchEvent.setBounds(centerX1, centerY, btnWidth, btnHeight);
        contentPane.add(btnSearchEvent);

        JButton btnSearchEventWCode = new JButton("Introducir código");
        btnSearchEventWCode.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnSearchEventWCode.setBounds(centerX2, centerY, btnWidth, btnHeight);
        contentPane.add(btnSearchEventWCode);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userModel currentUser = session.getCurrentUser();

                // llamar a la ventana Homepage
                homePage homepage = new homePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnSearchEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana searchEventPublic
                searchEventPublic publicEvent = new searchEventPublic(currentEvent);
                publicEvent.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnSearchEventWCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana searchEventWCode
                searchEventWCode wCodeEvent = new searchEventWCode(currentEvent);
                wCodeEvent.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}