package makingSocial.view.HostModel_View;

import makingSocial.DAO.HostModel_DAO.PrintCode_DAO;
import makingSocial.model.EventModel;
import makingSocial.view.UserProfile_View.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintCode extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel codeLabel;
    private JTextArea summaryArea;

    public PrintCode() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JLabel titleLabel = new JLabel("El código de tu evento es");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLabel.setBounds(238, 56, 461, 73);
        contentPane.add(titleLabel);

        codeLabel = new JLabel("XXXXXXX");
        codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        codeLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
        codeLabel.setBounds(238, 133, 461, 73);
        contentPane.add(codeLabel);

        JLabel summaryTitle = new JLabel("Resumen de tu evento:");
        summaryTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
        summaryTitle.setBounds(113, 264, 259, 50);
        contentPane.add(summaryTitle);

        summaryArea = new JTextArea();
        summaryArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        summaryArea.setEditable(false);
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        summaryArea.setBounds(113, 312, 728, 282);
        summaryArea.setBackground(contentPane.getBackground());
        summaryArea.setBorder(null);
        contentPane.add(summaryArea);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnGoHomePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomePage().setVisible(true);
                dispose();
            }
        });

        // Cargar y mostrar datos del evento
        //loadEvent(idEvent);
    }

    private void loadEvent(int idEvent) {
        EventModel event = PrintCode_DAO.getEventById(idEvent);

        if (event != null) {
            codeLabel.setText(String.valueOf(event.getID_Event()));

            // Construir resumen con saltos de línea
            StringBuilder resumen = new StringBuilder();
            resumen.append("Fecha: ").append(event.getDate()).append("\n");
            resumen.append("Hora: ").append(event.getSchedule()).append("\n");
            resumen.append("Lugar: ").append(event.getLocation()).append("\n");
            resumen.append("Código Postal: ").append(event.getPostalCode()).append("\n");
            resumen.append("Edad permitida: ").append(event.getAllowedAge()).append("\n");
            resumen.append("Evento privado: ").append(event.isAccess() ? "Sí" : "No").append("\n");
            resumen.append("Etiqueta (DressCode): ").append(event.isDressCode() ? event.getDescription1() : "Ninguna").append("\n");
            resumen.append("Temática (Theme): ").append(event.isTheme() ? event.getDescription2() : "Ninguna");

            summaryArea.setText(resumen.toString());
        } else {
            summaryArea.setText("No se encontró el evento con ID " + idEvent);
        }
    }
}
