package makingSocial.view.GuestModel_View;

import makingSocial.DAO.GuestModel_DAO.SearchEventPublic_DAO;
import makingSocial.model.EventModel;
import makingSocial.model.Session;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEventPublic extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldPostalCode;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public SearchEventPublic() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel titlePostalCode = new JLabel("Inserta un código postal");
        titlePostalCode.setHorizontalAlignment(SwingConstants.CENTER);
        titlePostalCode.setFont(new Font("Tahoma", Font.BOLD, 40));
        titlePostalCode.setBounds(144, 56, 658, 73);
        contentPane.add(titlePostalCode);

        textFieldPostalCode = new JTextField();
        textFieldPostalCode.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 45));
        textFieldPostalCode.setBounds(119, 139, 730, 57);
        contentPane.add(textFieldPostalCode);
        textFieldPostalCode.setColumns(10);

        JButton btnSearch = new JButton("Buscar");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSearch.setBounds(431, 206, 111, 36);
        contentPane.add(btnSearch);

        JLabel AttendEventLocation = new JLabel("Lorem ipsum dolor sit amet");
        AttendEventLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        AttendEventLocation.setBounds(173, 270, 275, 33);
        contentPane.add(AttendEventLocation);

        JLabel AttendEventSchedule = new JLabel("Lorem ipsum");
        AttendEventSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        AttendEventSchedule.setFont(new Font("Tahoma", Font.PLAIN, 15));
        AttendEventSchedule.setBounds(438, 272, 104, 33);
        contentPane.add(AttendEventSchedule);

        JLabel AttendEventToString = new JLabel("Lorem ipsum dolor sit amet");
        AttendEventToString.setFont(new Font("Tahoma", Font.PLAIN, 15));
        AttendEventToString.setBounds(173, 306, 562, 33);
        contentPane.add(AttendEventToString);

        JButton btnAttend = new JButton("Asistir");
        btnAttend.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAttend.setBounds(719, 275, 83, 27);
        contentPane.add(btnAttend);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int PostalCode = Integer.parseInt(textFieldPostalCode.getText());

                // Le pregunta a DAO por los objetos y los guarda en un arraylist
                List <EventModel> eventos = new SearchEventPublic_DAO().searchPublicEvent(PostalCode);

                // si no hay eventos muestra "No hay eventos en tu ciudad"
                if (eventos.isEmpty()) {
                    JLabel noEvent = new JLabel("No hay eventos en tu ciudad");
                    noEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
                    noEvent.setBounds(173, 270, 400, 33);
                    noEvent.setName("evento");
                    contentPane.add(noEvent);
                }
                // si hay eventos los muestra
                else {
                    // espacio desde la barra
                    int y = 270;
                    for (EventModel evento : eventos) {
                        // muestra el sitio
                        JLabel title = new JLabel(evento.getLocation());
                        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        title.setBounds(173, y, 275, 33);
                        title.setName("evento");
                        contentPane.add(title);

                        // muestra el horario
                        JLabel horario = new JLabel(String.valueOf(evento.getSchedule()));
                        horario.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        horario.setBounds(438, y, 104, 33);
                        horario.setName("evento");
                        contentPane.add(horario);

                        //toString
                        JLabel descripcion = new JLabel(evento.toString());
                        descripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        descripcion.setBounds(173, y + 36, 562, 33);
                        descripcion.setName("evento");
                        contentPane.add(descripcion);

                        JButton btnAsistir = new JButton("Asistir");
                        btnAsistir.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        btnAsistir.setBounds(719, y, 83, 27);
                        btnAsistir.setName("evento");
                        contentPane.add(btnAsistir);

                        btnAsistir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                EventFound eventFound = new EventFound();
                                eventFound.setVisible(true);
                                dispose();
                            }
                        });

                        // espacio entre eventos
                        y += 80;
                    }
                }

                // recalcula las posiciones de los componentes
                contentPane.revalidate();
                // fuerza que se redibuje la ventana
                contentPane.repaint();
            }
        });


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
    }
}
