package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class profileEditPhoto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                profileEditPhoto frame = new profileEditPhoto();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

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

        // Título
        JLabel lblNewLabel = new JLabel("¡Bienvenid@ al evento!");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(66, 40, 409, 77);
        contentPane.add(lblNewLabel);

        // Foto de perfil
        JLabel lblPhoto = new JLabel("");
        lblPhoto.setIcon(new ImageIcon(
                "C:\\Users\\carva\\Documents\\Making-social\\Making-social-Git\\src\\makingSocial\\profile.jpg"));
        lblPhoto.setBounds(65, 127, 410, 432);
        contentPane.add(lblPhoto);

        // Botones
        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JButton btnSmile = new JButton("¡Sonríe!");
        btnSmile.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSmile.addActionListener((ActionEvent e) -> {
            // acción aquí
        });
        btnSmile.setBounds(179, 581, 127, 40);
        contentPane.add(btnSmile);

        // Etiqueta "Recuerda:"
        JLabel lblNewLabel_1 = new JLabel("Recuerda:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(513, 127, 190, 40);
        contentPane.add(lblNewLabel_1);

        // JTextArea con wrap, solo lectura, sin scroll
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
        // Aumentamos la altura para que quepa todo el texto
        txtrDebesHacerteUna.setBounds(524, 187, 352, 255);
        contentPane.add(txtrDebesHacerteUna);

        // Botón extra
        JButton btnNewButton_1_2_1 = new JButton("Making Social!");
        btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1_2_1.setBounds(625, 486, 161, 40);
        contentPane.add(btnNewButton_1_2_1);
    }
}
