package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;

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
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    socialSearch frame = new socialSearch();
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
    public socialSearch() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre - Lorem Ipsum");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(66, 40, 337, 77);
        contentPane.add(lblNewLabel);

        JLabel lblPhoto = new JLabel("New label");
        lblPhoto.setIcon(new ImageIcon("C:\\Users\\carva\\Documents\\Making-social\\Making-social-Git\\src\\makingSocial\\profile.jpg"));
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

        JLabel lblNewLabelEdad = new JLabel("Edad");
        lblNewLabelEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabelEdad.setBounds(492, 361, 53, 30);
        contentPane.add(lblNewLabelEdad);

        JLabel lblLoremEdad = new JLabel("Lorem");
        lblLoremEdad.setBackground(UIManager.getColor("Button.background"));
        lblLoremEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoremEdad.setBounds(555, 361, 74, 30);
        contentPane.add(lblLoremEdad);

        JLabel lblLoremIpsumBIO = new JLabel("Lorem Ipsum");
        lblLoremIpsumBIO.setVerticalAlignment(SwingConstants.TOP);
        lblLoremIpsumBIO.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblLoremIpsumBIO.setBackground(UIManager.getColor("Button.background"));
        lblLoremIpsumBIO.setBounds(492, 127, 355, 202);
        contentPane.add(lblLoremIpsumBIO);

        JButton btn = new JButton("Volver a inicio");
        btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn.setBounds(784, 606, 140, 30);
        contentPane.add(btn);
    }
}