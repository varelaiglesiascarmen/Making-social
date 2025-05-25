package makingSocial.view.GuestModel_View;

import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class socialSearch extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public socialSearch() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        // aqui debe salir el nombre del otro user
        JLabel lblUserName = new JLabel("nombre de la persona");
        lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblUserName.setBounds(66, 40, 337, 77);
        contentPane.add(lblUserName);

        // aqui debe salir la foto del otro user
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
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_2.setBounds(492, 527, 98, 40);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_2_1 = new JButton("Pasar");
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_2_1.setBounds(711, 527, 98, 40);
        contentPane.add(btnNewButton_1_2_1);

        // solo debe salir en caso de coincidencia (que el otro user le halla dado a conocer)
        JLabel lblNewLabelRRSS = new JLabel("RRSS");
        lblNewLabelRRSS.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabelRRSS.setBounds(492, 420, 53, 30);
        contentPane.add(lblNewLabelRRSS);

        JLabel lblLoremRRSS = new JLabel("Lorem");
        lblLoremRRSS.setBackground(UIManager.getColor("Button.background"));
        lblLoremRRSS.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremRRSS.setBounds(555, 420, 74, 30);
        contentPane.add(lblLoremRRSS);

        // aqui debe salir la BIO del otro user
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

        // aqui debe salir la edad del otro user
        JLabel lblLabelEdad = new JLabel("Edad");
        lblLabelEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLabelEdad.setBounds(492, 460, 53, 30);
        contentPane.add(lblLabelEdad);

        JLabel lblLoremEdad = new JLabel("Lorem");
        lblLoremEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremEdad.setBackground(UIManager.getColor("Button.background"));
        lblLoremEdad.setBounds(555, 460, 74, 30);
        contentPane.add(lblLoremEdad);

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

        /* hay que contemplar que

        case 1: que muestre los usuarios

        case 2: cuando ya ha decidido si o no en todos los usuarios mensaje de "Ya no hay mas usuarios para interactuar. ¡Espero que disfrutases del evento!"

        default: si no ha habido otros registros salga un mensaje "¡Vaya parece que no ha habido usuarios en este evento!"

        */
    }
}