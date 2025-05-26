package makingSocial.view.GuestModel_View;

import makingSocial.model.eventModel;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private eventModel currentEvent;
    private userModel currentUser;

    public profile(userModel currentUser) {
        this.currentUser = currentUser;

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
                homePage homepage = new homePage();
                homepage.setVisible(true);
                dispose();
            }
        });

        btnMakingSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attendedEvents attendedEvents = new attendedEvents(currentUser);
                attendedEvents.setVisible(true);
                dispose();
            }
        });

        // mostrar ventana
        setVisible(true);
    }

    // Otros constructores que ya tienes (no los modificamos)

    public profile(eventModel currentEvent) {
        this.currentEvent = currentEvent;
    }

    public profile() {
        this.currentEvent = currentEvent;
    }
}