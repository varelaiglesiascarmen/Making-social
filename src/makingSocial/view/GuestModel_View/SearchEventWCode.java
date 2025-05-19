package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SearchEventWCode extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodeInsert;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchEventWCode frame = new SearchEventWCode();
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
    public SearchEventWCode() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleCodeInsert = new JLabel("Inserta el código del evento");
        titleCodeInsert.setHorizontalAlignment(SwingConstants.CENTER);
        titleCodeInsert.setFont(new Font("Tahoma", Font.BOLD, 40));
        titleCodeInsert.setBounds(171, 166, 658, 73);
        contentPane.add(titleCodeInsert);

        txtCodeInsert = new JTextField();
        txtCodeInsert.setHorizontalAlignment(SwingConstants.CENTER);
        txtCodeInsert.setFont(new Font("Tahoma", Font.PLAIN, 45));
        txtCodeInsert.setBounds(171, 288, 658, 73);
        contentPane.add(txtCodeInsert);
        txtCodeInsert.setColumns(10);

        JButton btnNewButtonAttend = new JButton("Asistir");
        btnNewButtonAttend.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButtonAttend.setBounds(431, 468, 111, 36);
        contentPane.add(btnNewButtonAttend);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

    }

}
