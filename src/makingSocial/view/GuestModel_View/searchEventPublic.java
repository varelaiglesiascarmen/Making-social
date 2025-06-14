package makingSocial.view.GuestModel_View;

import makingSocial.DAO.GuestModelDAO.searchEventPublicDAO;
import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class searchEventPublic extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldPostalCode;
    private eventModel currentEvent;

    public searchEventPublic(eventModel currentEvent) {
        this.currentEvent = currentEvent;
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

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int PostalCode = Integer.parseInt(textFieldPostalCode.getText());

                // Le pregunta a DAO por los objetos y los guarda en un arraylist
                List <eventModel> eventos = new searchEventPublicDAO().searchPublicEvent(PostalCode);

                // si no hay eventos muestra "No hay eventos en tu ciudad"
                if (eventos.isEmpty()) {
                    JLabel noEvent = new JLabel("No hay eventos en tu ciudad aún");
                    noEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
                    noEvent.setBounds(173, 270, 400, 33);
                    noEvent.setName("evento");
                    contentPane.add(noEvent);
                }
                // si hay eventos los muestra
                else {
                    // espacio desde la barra
                    int y = 270;
                    for (eventModel evento : eventos) {
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

                        // Comprueba Description1
                        String Description1;
                        if (evento.getDescription1() != null && !evento.getDescription1().isEmpty()) {
                            Description1 = evento.getDescription1();
                        } else {
                            Description1 = "No hay dress code";
                        }

                        // Comprueba Description2
                        String Description2;
                        if (evento.getDescription2() != null && !evento.getDescription2().isEmpty()) {
                            Description2 = evento.getDescription2();
                        } else {
                            Description2 = "No hay temática";
                        }

                        //toString
                        String descriptionText = String.format(
                                "Código de vestimenta: %s | Edad permitida: %d | Temática: %s",
                                Description1,
                                evento.getAllowedAge(),
                                Description2
                        );

                        JLabel descripcion = new JLabel(descriptionText);
                        descripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        descripcion.setBounds(173, y + 40, 650, 33);
                        descripcion.setName("evento");

                        contentPane.add(descripcion);

                        JButton btnAsistir = new JButton("Asistir");
                        btnAsistir.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        btnAsistir.setBounds(719, y + 20, 83, 27);
                        btnAsistir.setName("evento");
                        contentPane.add(btnAsistir);

                        btnAsistir.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                welcomeToEvent eventFound = new welcomeToEvent("default",evento);
                                eventFound.setVisible(true);
                                dispose();
                            }
                        });

                        // espacio entre eventos
                        y += 100;
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
                userModel currentUser = session.getCurrentUser();

                // llamar a la ventana Homepage
                homePage homepage = new homePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });
    }
}
