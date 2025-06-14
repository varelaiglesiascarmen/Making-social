package makingSocial.view.HostModel_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class notAllNodes extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public notAllNodes() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel errorTitle = new JLabel("Campos sin rellenar.");
        errorTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        errorTitle.setBounds(45, 26, 377, 45);
        contentPane.add(errorTitle);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(197, 128, 85, 21);
        contentPane.add(btnOk);

        JLabel errorTxt = new JLabel("Por favor, rellena todos los campos.");
        errorTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        errorTxt.setBounds(45, 81, 377, 21);
        contentPane.add(errorTxt);

        // al darle a ok se cierra la ventana
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
