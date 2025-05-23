package makingSocial.view.HostModel_View;

import makingSocial.DAO.HostModel_DAO.CreateEvent_DAO;
import makingSocial.model.EventModel;
import makingSocial.view.HostModel_View.PrintCode;
import makingSocial.view.HostModel_View.notAllNodes;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import makingSocial.DAO.HostModel_DAO.CreateEvent_DAO;
import makingSocial.model.EventModel;
import makingSocial.view.UserProfile_View.HomePage;


public class CreateEvent extends JFrame {


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldDirection;
    private JTextField textFieldCodePost;
    private JTextField textThemeDescription1;
    private JTextField textFieldAge;
    private JTextField textThemeDescription2;
    private JTextField textFieldSchedule;


    /**
     * Launch the application.
     */

     public CreateEvent() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1021, 796);
        getContentPane().setLayout(null);


        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());


        JLabel protocoloEvent = new JLabel("Añade el protocolo de tu evento:");
        protocoloEvent.setFont(new Font("Tahoma", Font.BOLD, 30));
        protocoloEvent.setBounds(331, 69, 496, 54);
        getContentPane().add(protocoloEvent);


        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setToolTipText("");
        dateChooser.setBounds(465, 161, 362, 35);
        getContentPane().add(dateChooser);


        JLabel lblHora = new JLabel("Hora");
        lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHora.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHora.setBounds(267, 206, 181, 35);
        getContentPane().add(lblHora);


        textFieldSchedule = new JTextField();
        textFieldSchedule.setColumns(10);
        textFieldSchedule.setBounds(465, 206, 362, 35);
        getContentPane().add(textFieldSchedule);


        JLabel lblEscribeLaHora = new JLabel("Escribe la hora así HH:MM");
        lblEscribeLaHora.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEscribeLaHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEscribeLaHora.setBounds(646, 244, 181, 35);
        getContentPane().add(lblEscribeLaHora);


        JLabel lblDirection = new JLabel("Dirección");
        lblDirection.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDirection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDirection.setBounds(267, 275, 181, 35);
        getContentPane().add(lblDirection);


        textFieldDirection = new JTextField();
        textFieldDirection.setBounds(465, 279, 362, 35);
        getContentPane().add(textFieldDirection);
        textFieldDirection.setColumns(10);


        JLabel lblCodePostal = new JLabel("Código Postal");
        lblCodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCodePostal.setBounds(267, 331, 181, 35);
        getContentPane().add(lblCodePostal);


        textFieldCodePost = new JTextField();
        textFieldCodePost.setColumns(10);
        textFieldCodePost.setBounds(465, 335, 362, 35);
        getContentPane().add(textFieldCodePost);


        JLabel lblDate = new JLabel("Fecha");
        lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDate.setBounds(267, 161, 181, 35);
        getContentPane().add(lblDate);


        JLabel lblDressCode = new JLabel("¿Tu fiesta tiene dress code?");
        lblDressCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDressCode.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDressCode.setBounds(163, 383, 285, 35);
        getContentPane().add(lblDressCode);


        JRadioButton rdbtnYesDress = new JRadioButton("Si");
        rdbtnYesDress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnYesDress.setBounds(454, 390, 103, 21);
        getContentPane().add(rdbtnYesDress);


        JRadioButton rdbtnNoDress = new JRadioButton("No");
        rdbtnNoDress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNoDress.setBounds(559, 390, 103, 21);
        getContentPane().add(rdbtnNoDress);


        ButtonGroup bgDress = new ButtonGroup();
        bgDress.add(rdbtnYesDress);
        bgDress.add(rdbtnNoDress);


        textThemeDescription1 = new JTextField();
        textThemeDescription1.setColumns(10);
        textThemeDescription1.setBounds(671, 387, 156, 35);
        getContentPane().add(textThemeDescription1);


        JLabel lblEdadPermitida = new JLabel("Edad permitida");
        lblEdadPermitida.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEdadPermitida.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEdadPermitida.setBounds(267, 428, 181, 35);
        getContentPane().add(lblEdadPermitida);


        textFieldAge = new JTextField();
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(465, 432, 362, 35);
        getContentPane().add(textFieldAge);


        JLabel lblTheme = new JLabel("¿Tu fiesta tiene alguna temática?  ");
        lblTheme.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTheme.setBounds(63, 477, 400, 35);
        getContentPane().add(lblTheme);


        JRadioButton rdbtnYesTheme = new JRadioButton("Si");
        rdbtnYesTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnYesTheme.setBounds(457, 484, 103, 21);
        getContentPane().add(rdbtnYesTheme);


        JRadioButton rdbtnNoTheme = new JRadioButton("No");
        rdbtnNoTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNoTheme.setBounds(562, 484, 103, 21);
        getContentPane().add(rdbtnNoTheme);


        ButtonGroup bgTheme = new ButtonGroup();
        bgTheme.add(rdbtnYesTheme);
        bgTheme.add(rdbtnNoTheme);


        textThemeDescription2 = new JTextField();
        textThemeDescription2.setColumns(10);
        textThemeDescription2.setBounds(671, 481, 156, 35);
        getContentPane().add(textThemeDescription2);


        JLabel lblAccess = new JLabel("El acceso al evento es:");
        lblAccess.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAccess.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccess.setBounds(51, 526, 400, 35);
        getContentPane().add(lblAccess);


        JRadioButton rdbtnYesPublic = new JRadioButton("Público");
        rdbtnYesPublic.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnYesPublic.setBounds(500, 569, 103, 21);
        getContentPane().add(rdbtnYesPublic);


        JRadioButton rdbtnNoPrivate = new JRadioButton("Privado");
        rdbtnNoPrivate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNoPrivate.setBounds(613, 569, 103, 21);
        getContentPane().add(rdbtnNoPrivate);


        ButtonGroup bgAccess = new ButtonGroup();
        bgAccess.add(rdbtnYesPublic);
        bgAccess.add(rdbtnNoPrivate);


        // Ocultar las descripciones al inicio de dressCode y Theme
        textThemeDescription1.setVisible(false);
        textThemeDescription1.setVisible(false);
        textThemeDescription2.setVisible(false);
        textThemeDescription2.setVisible(false);


        // Listener para mostrar/ocultar descripciones de dressCode y Theme
        ActionListener toggleDesc = e -> {
            boolean hasDress = rdbtnYesDress.isSelected();
            textThemeDescription1.setVisible(hasDress);
            textThemeDescription1.setVisible(hasDress);


            boolean hasTheme = rdbtnYesTheme.isSelected();
            textThemeDescription2.setVisible(hasTheme);
            textThemeDescription2.setVisible(hasTheme);
        };
        rdbtnYesDress.addActionListener(toggleDesc);
        rdbtnNoDress.addActionListener(toggleDesc);
        rdbtnYesTheme.addActionListener(toggleDesc);
        rdbtnNoTheme.addActionListener(toggleDesc);

        JButton btnSave = new JButton("Guardar evento");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBounds(559, 624, 218, 33);
        getContentPane().add(btnSave);

        JButton btnVolverAInicio = new JButton("Volver a inicio");
        btnVolverAInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnVolverAInicio.setBounds(779, 704, 218, 33);
        getContentPane().add(btnVolverAInicio);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        btnVolverAInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);


                // disppuse() cierra la venta
                dispose();
            }
        });

        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Formulario
                // antes de convertirla a LocalDate, recupera la fecha del JDateChooser
                Date chosen = dateChooser.getDate();
                // obligatorio
                LocalDate date = chosen.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                // obligatorio
                LocalTime schedule = LocalTime.parse(textFieldSchedule.getText());
                // obligatorio
                String location = textFieldDirection.getText();
                // obligatorio
                int PostalCode = Integer.parseInt(textFieldCodePost.getText());
                // obligatorio - “Sí” = true, “No” = false
                boolean dressCode = rdbtnYesDress.isSelected();
                // obligatorio - “Sí” = true, “No” = false
                boolean theme = rdbtnYesTheme.isSelected();
                // solo se visualiza si es true debe decir cuál es el dressDode, si es false guarda null
                String description1 = textThemeDescription1.getText();
                // solo se visualiza si es true debe decir cuál es la tematica, si es false guarda null
                String description2 = textThemeDescription2.getText();
                // obligatorio
                int allowedAge = Integer.parseInt(textFieldAge.getText());
                // obligatorio - “Público” = true, “Privado” = false
                boolean access = rdbtnYesPublic.isSelected();


                // Crear el objeto del modelo
                EventModel newEvent = new EventModel(date, schedule, location, PostalCode, dressCode, theme, description1, description2, allowedAge, access);


                // Los datos obligatorios están rellenos ?
                boolean insert = false;
                insert = new CreateEvent_DAO().ejecutarInsertDeleteUpdate(newEvent);


                // si están todos los campos
                if(insert == true){
                    // llamar a la ventana PrintCode
                    PrintCode newCode = new PrintCode();
                    newCode.setVisible(true);


                    // disppuse() cierra la venta
                    dispose();
                }
                // si no están todos los campos
                else {
                    notAllNodes lostNode = new notAllNodes();
                    lostNode.setVisible(true);
                }
            }
        });
    }
}
