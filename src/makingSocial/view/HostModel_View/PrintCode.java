package makingSocial.view.HostModel_View;

import makingSocial.view.UserProfile_View.HomePage;
import makingSocial.view.UserProfile_View.Login;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintCode extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrintCode frame = new PrintCode();
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
    public PrintCode() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/makingSocial/src/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel newCode = new JLabel("El código de tu evento es");
        newCode.setHorizontalAlignment(SwingConstants.CENTER);
        newCode.setFont(new Font("Tahoma", Font.BOLD, 30));
        newCode.setBounds(238, 56, 461, 73);
        contentPane.add(newCode);

        JLabel code = new JLabel("XXXXXXX");
        code.setHorizontalAlignment(SwingConstants.CENTER);
        code.setFont(new Font("Tahoma", Font.BOLD, 60));
        code.setBounds(238, 133, 461, 73);
        contentPane.add(code);

        JLabel lblNewLabel = new JLabel("Resumen de tu evento:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(113, 264, 259, 50);
        contentPane.add(lblNewLabel);

        JLabel toStringSummary = new JLabel("Lorem Ipsum");
        toStringSummary.setVerticalAlignment(SwingConstants.TOP);
        toStringSummary.setFont(new Font("Tahoma", Font.PLAIN, 20));
        toStringSummary.setBounds(113, 312, 728, 282);
        contentPane.add(toStringSummary);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

    }
}
