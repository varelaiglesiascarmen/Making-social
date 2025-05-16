package makingSocial.view.GuestModel_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EventNotFound extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EventNotFound frame = new EventNotFound();
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
    public EventNotFound() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel notFoundCodeTitle = new JLabel("Evento no encontrado");
        notFoundCodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        notFoundCodeTitle.setBounds(26, 26, 555, 45);
        contentPane.add(notFoundCodeTitle);

        JLabel notFoundCodeTxt = new JLabel("Inserte un código válido, si no lo tienes ¡siempre podrás buscar un evento!");
        notFoundCodeTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        notFoundCodeTxt.setBounds(36, 81, 631, 21);
        contentPane.add(notFoundCodeTxt);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);
    }

}
