package makingSocial.view.GuestModel_View;

import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class welcomeToEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private eventModel event;
    private String window;
    private JLabel messageLabel;

    public welcomeToEvent(String window, eventModel event) {
        this.event = event;
        this.window = window;
        setupUI();
    }

    public welcomeToEvent(eventModel currentEvent) {
        this.event = currentEvent;
        this.window = ""; // o null, según prefieras
        setupUI();
    }

    public void setupUI() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        messageLabel = new JLabel("¡Bienvenido al evento!");
        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        messageLabel.setBounds(26, 26, 555, 45);
        contentPane.add(messageLabel);

        updateMessageLabel();

        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(303, 131, 85, 21);
        contentPane.add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userModel currentUser = session.getCurrentUser();
                switch(window){
                    case "profileEditBIO":
                        homePage newlog = new homePage();
                        newlog.setVisible(true);
                        dispose();
                        break;
                    default:
                        LocalDateTime eventDateTime = LocalDateTime.of(event.getDate(), event.getSchedule());
                        LocalDateTime now = LocalDateTime.now();
                        Duration duration = Duration.between(now, eventDateTime);

                        if (duration.toMinutes() > 30){
                            homePage newlog2 = new homePage();
                            newlog2.setVisible(true);
                            dispose();
                        } else {
                            profileEditPhoto newlog3 = new profileEditPhoto(event);
                            newlog3.setVisible(true);
                            dispose();
                        }
                        break;
                }
            }
        });
    }

    private void updateMessageLabel() {
        switch(window) {
            case "profileEditBIO":
                messageLabel.setText("Desde tu perfil podrás empezar a conocer gente \n"+"24 horas después de que termine!");
                messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
                break;
            default:
                LocalDateTime eventDateTime = LocalDateTime.of(event.getDate(), event.getSchedule());
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(now, eventDateTime);

                if (duration.toMinutes() > 30) {
                    messageLabel.setText("Desde tu perfil podrás acceder al evento \n"+"media hora antes de que comience!");
                } else {
                    messageLabel.setText("Recuerda ser respetuos@ en el evento y pásatelo bien!");
                }
                messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
                break;
        }
    }

}