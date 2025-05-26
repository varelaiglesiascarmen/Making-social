package makingSocial.view.GuestModel_View;

import makingSocial.DAO.GuestModelDAO.socialSearchDAO;
import makingSocial.model.eventModel;
import makingSocial.model.guestModel;
import makingSocial.model.session;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class socialSearch extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private eventModel currentEvent;

    private List<guestModel> guestList;
    private int currentIndex = 0;

    public socialSearch(eventModel currentEvent) {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel lblUserName = new JLabel("nombre de la persona");
        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblUserName.setBounds(66, 40, 337, 77);
        contentPane.add(lblUserName);

        JLabel lblPhoto = new JLabel("New label");
        lblPhoto.setIcon(new ImageIcon("x"));
        lblPhoto.setBounds(65, 127, 355, 481);
        contentPane.add(lblPhoto);

        JButton btnNewButton_1 = new JButton("No conocer");
        btnNewButton_1.setBounds(603, 527, 98, 40);
        contentPane.add(btnNewButton_1);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JButton btnNewButton_1_2 = new JButton("Conocer");
        btnNewButton_1_2.setBounds(492, 527, 98, 40);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_2_1 = new JButton("Pasar");
        btnNewButton_1_2_1.setBounds(711, 527, 98, 40);
        contentPane.add(btnNewButton_1_2_1);

        JLabel lblNewLabelRRSS = new JLabel("RRSS");
        lblNewLabelRRSS.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabelRRSS.setBounds(492, 420, 53, 30);
        contentPane.add(lblNewLabelRRSS);

        JLabel lblLoremRRSS = new JLabel("Lorem");
        lblLoremRRSS.setBackground(UIManager.getColor("Button.background"));
        lblLoremRRSS.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremRRSS.setBounds(555, 420, 74, 30);
        contentPane.add(lblLoremRRSS);

        JLabel lblLoremIpsumBIO = new JLabel("Saludo (BIO)");
        lblLoremIpsumBIO.setVerticalAlignment(SwingConstants.TOP);
        lblLoremIpsumBIO.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblLoremIpsumBIO.setBackground(UIManager.getColor("Button.background"));
        lblLoremIpsumBIO.setBounds(492, 127, 355, 202);
        contentPane.add(lblLoremIpsumBIO);

        JButton btn = new JButton("Volver a inicio");
        btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn.setBounds(784, 606, 140, 30);
        contentPane.add(btn);

        JLabel lblLabelEdad = new JLabel("Edad");
        lblLabelEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLabelEdad.setBounds(492, 460, 53, 30);
        contentPane.add(lblLabelEdad);

        JLabel lblLoremEdad = new JLabel("Lorem");
        lblLoremEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremEdad.setBackground(UIManager.getColor("Button.background"));
        lblLoremEdad.setBounds(555, 460, 74, 30);
        contentPane.add(lblLoremEdad);

        btnGoHomePage.addActionListener(e -> {
            homePage homepage = new homePage();
            homepage.setVisible(true);
            dispose();
        });

        loadData(lblUserName, lblPhoto, lblLoremIpsumBIO, lblLoremRRSS, lblLoremEdad);

        // Acciones de los botones
        ActionListener nextProfileAction = e -> nextProfile(lblUserName, lblPhoto, lblLoremIpsumBIO, lblLoremRRSS, lblLoremEdad);

        btnNewButton_1_2_1.addActionListener(nextProfileAction); // Pasar
        btnNewButton_1.addActionListener(nextProfileAction);     // No conocer
        btnNewButton_1_2.addActionListener(nextProfileAction);   // Conocer
    }

    private void loadData(JLabel lblUserName, JLabel lblPhoto, JLabel lblBio, JLabel lblRRSS, JLabel lblEdad) {
        if (currentEvent == null) {
            JOptionPane.showMessageDialog(this, "No hay evento seleccionado.");
            dispose();
            return;
        }

        guestList = socialSearchDAO.getGuestsByEvent(currentEvent.getID_Event());

        if (guestList.isEmpty()) {
            // Muestra mensaje de que no hay usuarios
        } else {
            showProfile(0, lblUserName, lblPhoto, lblBio, lblRRSS, lblEdad);
        }
    }

    private void showProfile(int index, JLabel lblUserName, JLabel lblPhoto, JLabel lblBio, JLabel lblRRSS, JLabel lblEdad) {
        if (index < 0 || index >= guestList.size()) {
            JOptionPane.showMessageDialog(this, "Ya no quedan más usuarios para revisar.");
            dispose();
            return;
        }

        guestModel guest = guestList.get(index);
        session.setCurrentGuest(guest);

        // Mostrar datos
        lblUserName.setText(guest.getName());

        if (guest.getPhoto() != null && guest.getPhoto().length > 0) {
            ImageIcon icon = new ImageIcon(guest.getPhoto());
            Image img = icon.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
            lblPhoto.setIcon(new ImageIcon(img));
        } else {
            lblPhoto.setIcon(new ImageIcon("x")); // Imagen por defecto
        }

        lblBio.setText("Saludo (" + guest.getCivilStatus() + ")");
        lblRRSS.setText(guest.getRRSS());
        lblEdad.setText(String.valueOf(guest.getAge()));
    }

    private void nextProfile(JLabel lblUserName, JLabel lblPhoto, JLabel lblBio, JLabel lblRRSS, JLabel lblEdad) {
        currentIndex++;
        if (currentIndex < guestList.size()) {
            showProfile(currentIndex, lblUserName, lblPhoto, lblBio, lblRRSS, lblEdad);
        } else {
            JOptionPane.showMessageDialog(this, "Has terminado de revisar todos los perfiles.");
            dispose();
        }
    }
}