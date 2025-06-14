package makingSocial.view.GuestModel_View;

import makingSocial.DAO.GuestModelDAO.profileEditBIODAO;
import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class profileEditBIO extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private eventModel event;
    private String photoPath; // Ruta de la imagen seleccionada
    private userModel currentUser;

    public profileEditBIO(userModel currentUser, eventModel event, String photoPath) {
        this.currentUser  = session.getCurrentUser();
        this.event = event;
        this.photoPath = photoPath;

        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel lblName = new JLabel("¡Hola, " + this.currentUser.getName() + "!");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblName.setBounds(66, 40, 337, 77);
        contentPane.add(lblName);

        JLabel lblPhoto = new JLabel("New label");
        lblPhoto.setIcon(new ImageIcon(photoPath)); // Mostramos la imagen seleccionada
        lblPhoto.setBounds(65, 127, 355, 481);
        contentPane.add(lblPhoto);

        JButton btnNewButtonMakingSocial = new JButton("Making Social!");
        btnNewButtonMakingSocial.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButtonMakingSocial.setBounds(625, 529, 155, 40);
        contentPane.add(btnNewButtonMakingSocial);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JLabel lblNewLabelEdad = new JLabel("¡Di tu Instagram para que puedan localizarte!");
        lblNewLabelEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabelEdad.setBounds(492, 294, 416, 30);
        contentPane.add(lblNewLabelEdad);

        JLabel lblLoremEdad = new JLabel("¡Descríbete!");
        lblLoremEdad.setBackground(UIManager.getColor("Button.background"));
        lblLoremEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremEdad.setBounds(492, 127, 127, 30);
        contentPane.add(lblLoremEdad);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBounds(492, 167, 409, 117);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1.setText(" @");
        textField_1.setColumns(10);
        textField_1.setBounds(492, 358, 409, 48);
        contentPane.add(textField_1);

        JLabel lblculEsTu = new JLabel("¿Qué buscas por aquí?");
        lblculEsTu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblculEsTu.setBounds(492, 431, 209, 30);
        contentPane.add(lblculEsTu);

        JRadioButton rdbtnAmistad = new JRadioButton("Amistad");
        rdbtnAmistad.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnAmistad.setBounds(516, 477, 103, 21);
        contentPane.add(rdbtnAmistad);

        JRadioButton rdbtnLige = new JRadioButton("Lige");
        rdbtnLige.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnLige.setBounds(642, 477, 70, 21);
        contentPane.add(rdbtnLige);

        JRadioButton rdbtnAmor = new JRadioButton("Amor");
        rdbtnAmor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnAmor.setBounds(738, 477, 103, 21);
        contentPane.add(rdbtnAmor);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnAmistad);
        group.add(rdbtnLige);
        group.add(rdbtnAmor);

        JLabel lblSoloLoVern = new JLabel("Solo lo verán en caso de coincidencia  ");
        lblSoloLoVern.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSoloLoVern.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSoloLoVern.setBounds(642, 322, 259, 30);
        contentPane.add(lblSoloLoVern);

        btnGoHomePage.addActionListener(e -> {
            homePage homepage = new homePage();
            homepage.setVisible(true);
            dispose();
        });

        btnNewButtonMakingSocial.addActionListener(e -> {
            String insta = textField_1.getText().trim();
            if (insta.isEmpty() || insta.equals("@")) {
                JOptionPane.showMessageDialog(profileEditBIO.this,
                        "Rellena todos los campos",
                        "Error: Instagram",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String civilStatus = "";
            if (rdbtnAmistad.isSelected()) civilStatus = "Amistad";
            else if (rdbtnLige.isSelected()) civilStatus = "Ligue";
            else if (rdbtnAmor.isSelected()) civilStatus = "Amor";
            else {
                JOptionPane.showMessageDialog(profileEditBIO.this,
                        "Selecciona una opción",
                        "Error: Selección",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String bio = textField.getText();

            profileEditBIODAO dao = new profileEditBIODAO();
            int guestID = dao.saveGuestModel(currentUser, photoPath, civilStatus, insta, bio);

            if (guestID != -1 && dao.insertIntoLogs(guestID, event.getID_Event())) {
                welcomeToEvent eventFound = new welcomeToEvent("profileEditBIO", event);
                eventFound.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(profileEditBIO.this,
                        "Error al guardar los datos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}