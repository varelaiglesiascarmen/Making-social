package makingSocial.view.GuestModel_View;

import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class WelcomeToEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private EventModel currentEvent;
    private String window;

    // Constructor que recibe 'window' y 'currentEvent'
    public WelcomeToEvent(String window, EventModel currentEvent) {
        this.currentEvent = currentEvent;
        this.window = window; // ahora usa el valor del parámetro
        // initialize(); eliminado por no existir
    }

    // Constructor principal de la ventana GUI
    public WelcomeToEvent(EventModel currentEvent) {
        this.currentEvent = currentEvent;
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            setIconImage(icon.getImage());
        }

        // Título
        JLabel notFoundCodeTitle = new JLabel("¡Bienvenido al evento!");
        notFoundCodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        notFoundCodeTitle.setBounds(26, 26, 555, 45);
        contentPane.add(notFoundCodeTitle);

        // Botón Ok
        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);

        // Acción del botón
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(window){
                    case "profileEditBIO":
                        JLabel notFoundCodeTxt = new JLabel("Desde tu perfil podrás empezar a conocer gente\n24 horas después de que termine!");
                        notFoundCodeTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
                        notFoundCodeTxt.setBounds(36, 81, 631, 21);
                        contentPane.add(notFoundCodeTxt);
                        revalidate();
                        repaint();

                        HomePage newlog = new HomePage();
                        newlog.setVisible(true);
                        dispose();
                        break;

                    default:
                        LocalDateTime eventDateTime = LocalDateTime.of(currentEvent.getDate(), currentEvent.getSchedule());
                        LocalDateTime now = LocalDateTime.now();
                        Duration duration = Duration.between(now, eventDateTime);

                        if (duration.toMinutes() > 30) {
                            JLabel notFoundCodeTxt2 = new JLabel("Desde tu perfil podrás acceder al evento\nmedia hora antes de que comience!");
                            notFoundCodeTxt2.setFont(new Font("Tahoma", Font.PLAIN, 18));
                            notFoundCodeTxt2.setBounds(36, 81, 631, 21);
                            contentPane.add(notFoundCodeTxt2);
                            revalidate();
                            repaint();

                            HomePage newlog2 = new HomePage();
                            newlog2.setVisible(true);
                            dispose();
                        } else {
                            JLabel notFoundCodeTxt3 = new JLabel("Recuerda ser respetuos@ en\nel evento y pasartelo bien!");
                            notFoundCodeTxt3.setFont(new Font("Tahoma", Font.PLAIN, 18));
                            notFoundCodeTxt3.setBounds(36, 81, 631, 21);
                            contentPane.add(notFoundCodeTxt3);
                            revalidate();
                            repaint();

                            profileEditPhoto newlog3 = new profileEditPhoto(currentEvent);
                            newlog3.setVisible(true);
                            dispose();
                        }
                        break;
                }
            }
        });

        setVisible(true); // Mostrar la ventana
    }

    public void setWindow(String window) {
        this.window = window;
    }
}