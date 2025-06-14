package makingSocial.view.GuestModel_View;

import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class profileEditPhoto extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private boolean fotoSeleccionada = false;
    private eventModel currentEvent;
    private String imagePath = ""; // Almacena la ruta de la imagen
    private userModel currentUser;
    private JLabel lblPhoto;

    public profileEditPhoto(eventModel currentEvent) {
        this.currentEvent = currentEvent;
        this.currentUser = session.getCurrentUser();
        this.imagePath   = imagePath;

        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1012, 703);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel lblWelcome = new JLabel("¡Bienvenid@ al evento!");
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblWelcome.setBounds(66, 40, 409, 77);
        contentPane.add(lblWelcome);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        lblPhoto = new JLabel();
        lblPhoto.setBounds(76, 127, 387, 427);
        lblPhoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(lblPhoto);

        JButton btnSmile = new JButton("¡Sonríe!");
        btnSmile.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSmile.setBounds(207, 578, 127, 40);
        contentPane.add(btnSmile);

        JButton btnMakingSocial = new JButton("Making Social!");
        btnMakingSocial.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnMakingSocial.setBounds(625, 486, 161, 40);
        contentPane.add(btnMakingSocial);

        JLabel lblRemember = new JLabel("Recuerda:");
        lblRemember.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblRemember.setBounds(513, 127, 190, 40);
        contentPane.add(lblRemember);

        JTextArea txtrPhoto = new JTextArea();
        txtrPhoto.setTabSize(0);
        txtrPhoto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtrPhoto.setText(
                "Debes hacerte una foto del día del evento.\n"+" ¡Así podrán reconocerte rápidamente!\n" +
                        "Debes ser respetuos@ con el resto de asistentes del evento.\n\n" +
                        "No podrás ver el resto de invitados hasta que no pasen 24 hrs. \n¡Lo hacemos para que puedas disfrutar del evento con tus amigos \n"+" y no te quedes pegado al móvil!\n\n" +
                        "¡Que disfrutes del evento!"
        );
        txtrPhoto.setWrapStyleWord(true);
        txtrPhoto.setEditable(false);
        txtrPhoto.setBackground(UIManager.getColor("Button.background"));
        txtrPhoto.setBounds(524, 187, 448, 255);
        contentPane.add(txtrPhoto);

        btnGoHomePage.addActionListener(e -> {
            userModel currentUser = session.getCurrentUser();
            homePage homepage = new homePage();
            homepage.setVisible(true);
            dispose();
        });

        btnSmile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selecciona una imagen de perfil");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(
                    new FileNameExtensionFilter("Imágenes (.jpg, .png, .jpeg)", "jpg","jpeg","png")
            );
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imagePath = selectedFile.getAbsolutePath();
                fotoSeleccionada = true;

                // Escala imagen
                ImageIcon icon2 = new ImageIcon(imagePath);
                Image img = icon2.getImage()
                        .getScaledInstance(
                                lblPhoto.getWidth(),
                                lblPhoto.getHeight(),
                                Image.SCALE_SMOOTH
                        );
                lblPhoto.setIcon(new ImageIcon(img));
            }
        });


        btnMakingSocial.addActionListener(e -> {
            if (fotoSeleccionada) {
                profileEditBIO ventana = new profileEditBIO(currentUser, currentEvent, imagePath);
                ventana.setVisible(true);

                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Primero debes subir una foto con el botón '¡Sonríe!'", "Foto requerida", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}