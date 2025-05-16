package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Profile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Profile frame = new Profile();
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
    public Profile() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnMakingSocial = new JButton("Making Social!");
        btnMakingSocial.setFont(new Font("Tahoma", Font.PLAIN, 40));
        btnMakingSocial.setBounds(228, 242, 518, 160);
        contentPane.add(btnMakingSocial);

        JButton btnCfgProfile = new JButton("Cfg");
        btnCfgProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCfgProfile.setBounds(875, 612, 60, 40);
        contentPane.add(btnCfgProfile);
    }
}
