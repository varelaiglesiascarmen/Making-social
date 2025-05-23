package makingSocial.view.GuestModel_View;

import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class profileEditPhoto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private boolean fotoSeleccionada = false; // nueva variable

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public profileEditPhoto() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel lblNewLabel = new JLabel("¡Bienvenid@ al evento!");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(66, 40, 409, 77);
        contentPane.add(lblNewLabel);

        ImageIcon lblPhoto = new ImageIcon("/img/profile.png.png");
        setIconImage(lblPhoto.getImage());

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JButton btnSmile = new JButton("¡Sonríe!");
        btnSmile.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSmile.setBounds(179, 581, 127, 40);
        contentPane.add(btnSmile);

        JButton btnNewButtonMakingSocial = new JButton("Making Social!");
        btnNewButtonMakingSocial.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButtonMakingSocial.setBounds(625, 486, 161, 40);
        contentPane.add(btnNewButtonMakingSocial);

        JLabel lblNewLabel_1 = new JLabel("Recuerda:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(513, 127, 190, 40);
        contentPane.add(lblNewLabel_1);

        JTextArea txtrDebesHacerteUna = new JTextArea();
        txtrDebesHacerteUna.setTabSize(0);
        txtrDebesHacerteUna.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtrDebesHacerteUna.setText(
                "Debes hacerte una foto del día del evento. ¡Así podrán reconocerte rápidamente!" +
                        "\n\nDebes ser respetuos@ con el resto de asistentes del evento.\n" +
                        "\nNo podrás ver el resto de invitados hasta que no pasen 24 hrs. \n\n¡Lo hacemos para que " +
                        "puedas disfrutar del evento con tus amigos y no te quedes pegado al móvil!\n\n\n" +
                        "¡Que disfrutes del evento!"
        );

        txtrDebesHacerteUna.setWrapStyleWord(true);
        txtrDebesHacerteUna.setEditable(false);
        txtrDebesHacerteUna.setBackground(UIManager.getColor("Button.background"));
        txtrDebesHacerteUna.setBounds(524, 187, 352, 255);
        contentPane.add(txtrDebesHacerteUna);

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

        btnSmile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona una imagen de perfil");

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (.jpg, .png, .jpeg)", "jpg", "jpeg", "png"));

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();
                    System.out.println("Imagen seleccionada: " + imagePath);

                    // marcar que se ha subido la foto
                    fotoSeleccionada = true;

                    // opcional: podrías mostrar la imagen seleccionada en lblPhoto
                    //lblPhoto.setIcon(new ImageIcon(imagePath));
                } else {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una imagen para continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnNewButtonMakingSocial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fotoSeleccionada) {
                    profileEditBIO profileBIO = new profileEditBIO();
                    profileBIO.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debes subir una foto con el botón '¡Sonríe!'", "Foto requerida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
