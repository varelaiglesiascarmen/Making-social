package makingSocial.view.GuestModel_View;

import makingSocial.view.HostModel_View.CreateEvent;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchEvent frame = new SearchEvent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SearchEvent() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/makingSocial/src/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        // Tamaño del botón
        int btnWidth = 383;
        int btnHeight = 185;
        // Coordenadas centradas horizontalmente (mitad de la ventana menos mitad del botón)
        int centerX1 = (960 / 2) - btnWidth - 25; // botón izquierdo
        int centerX2 = (960 / 2) + 25; // botón derecho
        int centerY = 220;

        // solo pueden salir los públicos
        JButton btnCreateEvent = new JButton("Buscar evento");
        btnCreateEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnCreateEvent.setBounds(centerX1, centerY, btnWidth, btnHeight);
        contentPane.add(btnCreateEvent);

        JButton btnAttendEvent = new JButton("Introducir código");
        btnAttendEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnAttendEvent.setBounds(centerX2, centerY, btnWidth, btnHeight);
        contentPane.add(btnAttendEvent);

        // Botón de perfil (esquina superior izquierda)
        JButton btnProfile = new JButton("ImgPerfil");
        btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProfile.setBounds(10, 10, 100, 40);
        contentPane.add(btnProfile);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnCreateEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana SearchEventPublic
                SearchEventPublic publicEvent = new SearchEventPublic();
                publicEvent.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnAttendEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana SearchEventWCode
                SearchEventWCode wCodeEvent = new SearchEventWCode();
                wCodeEvent.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Profile
                Profile img = new Profile();
                img.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
