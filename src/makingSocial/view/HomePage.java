package makingSocial.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class HomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage frame = new HomePage();
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
    public HomePage() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Tamaño del botón
        int btnWidth = 383;
        int btnHeight = 185;
        // Coordenadas centradas horizontalmente (mitad de la ventana menos mitad del botón)
        int centerX1 = (960 / 2) - btnWidth - 25; // botón izquierdo
        int centerX2 = (960 / 2) + 25; // botón derecho
        int centerY = 220;

        JButton btnCreateEvent = new JButton("Crear evento");
        btnCreateEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnCreateEvent.setBounds(centerX1, centerY, btnWidth, btnHeight);
        contentPane.add(btnCreateEvent);

        JButton btnAttendEvent = new JButton("Asistir a evento");
        btnAttendEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnAttendEvent.setBounds(centerX2, centerY, btnWidth, btnHeight);
        contentPane.add(btnAttendEvent);

        // Botón de perfil (esquina superior izquierda)
        JButton btnProfile = new JButton("ImgPerfil");
        btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProfile.setBounds(10, 10, 100, 40);
        contentPane.add(btnProfile);

        // Botón configuración (parte inferior derecha)
        JButton btnCfg = new JButton("Cfg");
        btnCfg.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCfg.setBounds(875, 612, 60, 40);
        contentPane.add(btnCfg);

        // Botón reporte (junto a configuración)
        JButton btnReport = new JButton("!");
        btnReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReport.setBounds(834, 622, 30, 30);
        contentPane.add(btnReport);
    }
}
