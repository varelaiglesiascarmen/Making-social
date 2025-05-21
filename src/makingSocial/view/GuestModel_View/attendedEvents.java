package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class attendedEvents extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    attendedEvents frame = new attendedEvents();
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
    public attendedEvents() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/makingSocial/src/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel titleAttendEvent = new JLabel("Eventos asistidos:");
        titleAttendEvent.setFont(new Font("Tahoma", Font.BOLD, 40));
        titleAttendEvent.setBounds(58, 51, 640, 90);
        contentPane.add(titleAttendEvent);

        // Listados de los eventos a los que ha asistido
        JLabel AttendEvent = new JLabel("Lorem ipsum dolor sit amet");
        AttendEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        AttendEvent.setBounds(58, 176, 583, 33);
        contentPane.add(AttendEvent);

        // botón de acceder
        JButton btnNewButton = new JButton(".");
        btnNewButton.setBounds(651, 178, 42, 36);
        contentPane.add(btnNewButton);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

    }
}
