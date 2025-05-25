package makingSocial.view.GuestModel_View;

import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

import static jdk.internal.misc.OSEnvironment.initialize;

public class WelcomeToEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private EventModel currentEvent;
    private String window;

    public WelcomeToEvent(String window, EventModel currentEvent) {
        this.currentEvent = currentEvent;
        this.window = "window";
        initialize();
    }

    public WelcomeToEvent(EventModel currentEvent) {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel notFoundCodeTitle = new JLabel("¡Bienvenido al evento!");
        notFoundCodeTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        notFoundCodeTitle.setBounds(26, 26, 555, 45);
        contentPane.add(notFoundCodeTitle);

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llama a la ventana en la q está para saber como seguir con la lógica del codig
                switch(window){
                    case "profileEditBIO":
                        JLabel notFoundCodeTxt = new JLabel("Desde tu perfil podrás empezar a conocer gente\n"+" 24 horas despues de que termine!");
                        notFoundCodeTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
                        notFoundCodeTxt.setBounds(36, 81, 631, 21);
                        contentPane.add(notFoundCodeTxt);

                        UserModel currentUser = Session.getCurrentUser();

                        HomePage newlog = new HomePage();
                        newlog.setVisible(true);

                        dispose();
                        break;
                    default:
                        // si queda mas de media hora para que el evento comience lo manda a homepage
                        LocalDateTime eventDateTime = LocalDateTime.of(currentEvent.getDate(), currentEvent.getSchedule());
                        LocalDateTime now = LocalDateTime.now();
                        Duration duration = Duration.between(now, eventDateTime);

                        if (duration.toMinutes() > 30){
                            JLabel notFoundCodeTxt2 = new JLabel("Desde tu perfil podrás acceder al evento\n"+" media hora antes de que comience!");
                            notFoundCodeTxt2.setFont(new Font("Tahoma", Font.PLAIN, 18));
                            notFoundCodeTxt2.setBounds(36, 81, 631, 21);
                            contentPane.add(notFoundCodeTxt2);

                            UserModel currentUser = Session.getCurrentUser();

                            HomePage newlog2 = new HomePage();
                            newlog2.setVisible(true);

                            dispose();
                        }
                        // si queda 30 min le deja entrar
                        else{
                            JLabel notFoundCodeTxt3 = new JLabel("Recuerda ser respetuos@ en\n+ el evento y pasartelo bien!");
                            notFoundCodeTxt3.setFont(new Font("Tahoma", Font.PLAIN, 18));
                            notFoundCodeTxt3.setBounds(36, 81, 631, 21);
                            contentPane.add(notFoundCodeTxt3);

                            profileEditPhoto newlog3 = new profileEditPhoto(currentEvent);
                            newlog3.setVisible(true);

                            dispose();

                        }
                        break;

                }

            }
        });
    }

}
