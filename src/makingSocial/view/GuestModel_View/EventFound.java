package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EventFound extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public EventFound() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel FoundCodeTitle = new JLabel("Evento encontrado");
        FoundCodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        FoundCodeTitle.setBounds(26, 26, 555, 45);
        contentPane.add(FoundCodeTitle);

        JLabel FoundCodeTxt = new JLabel("Podrás interactuar con el evento media hora antes de éste, ¡sonríe en la foto!");
        FoundCodeTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        FoundCodeTxt.setBounds(36, 81, 631, 21);
        contentPane.add(FoundCodeTxt);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);

        // al darle a ok se cierra la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileEditPhoto profileWindow = new profileEditPhoto();
                profileWindow.setVisible(true);
                dispose();
            }
        });
    }

}
