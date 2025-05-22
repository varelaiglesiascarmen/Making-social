package makingSocial.view.GuestModel_View;

import makingSocial.model.EventModel;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel titleAttendEvent = new JLabel("Eventos asistidos:");
        titleAttendEvent.setFont(new Font("Tahoma", Font.BOLD, 40));
        titleAttendEvent.setBounds(58, 51, 640, 90);
        contentPane.add(titleAttendEvent);

        // DAO: obtener eventos asistidos por el usuario
        /*List <EventModel> eventosAsistidos = new AttendedEvents_DAO().obtenerEventosAsistidosPorUsuario(EventModel.getID_Event());

        if (eventosAsistidos.isEmpty()) {
            JLabel sinEventos = new JLabel("¡Aún no has asistido a ningún evento! Busca tu próximo evento en la página de inicio.");
            sinEventos.setFont(new Font("Tahoma", Font.PLAIN, 20));
            sinEventos.setBounds(58, 176, 800, 33);
            contentPane.add(sinEventos);
        } else {
            int y = 176;
            for (EventModel evento : eventosAsistidos) {
                // imprime el codigo identificativo
                JLabel lblCode = new JLabel(String.valueOf(evento.getID_Event()));
                lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblCode.setBounds(58, y, 583, 33);
                contentPane.add(lblCode);

                JButton btnExplorar = new JButton("Explorar");
                btnExplorar.setBounds(660, y, 100, 33);
                contentPane.add(btnExplorar);

                btnExplorar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        socialSearch socialchat = new socialSearch();
                        socialchat.setVisible(true);
                        dispose();
                    }
                });

                y += 50;
            }
        }

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
        });*/

    }
}
