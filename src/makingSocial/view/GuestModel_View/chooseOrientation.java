//ventana para usar en la próxima versión

package makingSocial.view.GuestModel_View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// esta ventana no podrá visualizarse hasta 24 hrs después de que empiece el evento
public class chooseOrientation extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    chooseOrientation frame = new chooseOrientation();
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
    public chooseOrientation() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JButton btnChoose = new JButton("Hombres");
        btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnChoose.setBounds(325, 100, 356, 96);
        contentPane.add(btnChoose);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        JButton btnMujeres = new JButton("Mujeres");
        btnMujeres.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnMujeres.setBounds(325, 240, 356, 96);
        contentPane.add(btnMujeres);

        JButton btnAmbos = new JButton("Ambos");
        btnAmbos.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnAmbos.setBounds(325, 379, 356, 96);
        contentPane.add(btnAmbos);
    }

}
