package makingSocial.view.GuestModel_View;

/*import makingSocial.DAO.GuestModel_DAO.SearchEventWCode_DAO;*/
import makingSocial.DAO.GuestModel_DAO.SearchEventWCode_DAO;
import makingSocial.DAO.UserProfile_DAO.SignIn_DAO;
import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchEventWCode extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodeInsert;
    private EventModel event;

    public SearchEventWCode(EventModel event) {
        this.event = event;
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel titleCodeInsert = new JLabel("Inserta el código del evento");
        titleCodeInsert.setHorizontalAlignment(SwingConstants.CENTER);
        titleCodeInsert.setFont(new Font("Tahoma", Font.BOLD, 40));
        titleCodeInsert.setBounds(171, 166, 658, 73);
        contentPane.add(titleCodeInsert);

        txtCodeInsert = new JTextField();
        txtCodeInsert.setHorizontalAlignment(SwingConstants.CENTER);
        txtCodeInsert.setFont(new Font("Tahoma", Font.PLAIN, 45));
        txtCodeInsert.setBounds(171, 288, 658, 73);
        contentPane.add(txtCodeInsert);
        txtCodeInsert.setColumns(10);

        JButton btnNewButtonAttend = new JButton("Asistir");
        btnNewButtonAttend.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButtonAttend.setBounds(431, 468, 111, 36);
        contentPane.add(btnNewButtonAttend);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel currentUser = Session.getCurrentUser();

                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        btnNewButtonAttend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int eventId = Integer.parseInt(txtCodeInsert.getText().trim());

                    EventModel event = SearchEventWCode_DAO.buscarEventoPorId(eventId);

                    if (event != null) {
                        // Si el evento existe, abrir ventana WelcomeToEvent
                        WelcomeToEvent eventFound = new WelcomeToEvent("default",event);
                        eventFound.setVisible(true);

                        dispose();
                    } else {
                        // Si el evento no existe, abrir ventana EventNotFound
                        EventNotFound eventNotFound = new EventNotFound();
                        eventNotFound.setVisible(true);

                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número de ID válido.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar el evento.");
                }
            }
        });


    }

}
