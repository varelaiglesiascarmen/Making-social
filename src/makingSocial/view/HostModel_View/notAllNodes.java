package makingSocial.view.HostModel_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class notAllNodes extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    notAllNodes frame = new notAllNodes();
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
    public notAllNodes() {
        setTitle("Making Social! - 404 not found");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

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
