package makingSocial.view.GuestModel_View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eventNotFound extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public eventNotFound() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

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

        // al darle a ok se cierra la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
