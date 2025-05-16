package makingSocial.view;

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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class profileEditBIO extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    profileEditBIO frame = new profileEditBIO();
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
    public profileEditBIO() {
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
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(629, 527, 127, 40);
        contentPane.add(btnNewButton_1);


        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JButton btnNewButton_1_2 = new JButton("Conocer");
        btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_2.setBounds(492, 527, 127, 40);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_2_1 = new JButton("Pasar");
        btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_2_1.setBounds(766, 527, 117, 40);
        contentPane.add(btnNewButton_1_2_1);

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

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Amistad");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnNewRadioButton.setBounds(516, 477, 103, 21);
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnLige = new JRadioButton("Lige");
        rdbtnLige.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnLige.setBounds(642, 477, 70, 21);
        contentPane.add(rdbtnLige);

        JRadioButton rdbtnAmor = new JRadioButton("Amor");
        rdbtnAmor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rdbtnAmor.setBounds(738, 477, 103, 21);
        contentPane.add(rdbtnAmor);

        JLabel lblSoloLoVern = new JLabel("Solo lo verán en caso de coincidencia  ");
        lblSoloLoVern.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSoloLoVern.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSoloLoVern.setBounds(642, 322, 259, 30);
        contentPane.add(lblSoloLoVern);
    }
}
