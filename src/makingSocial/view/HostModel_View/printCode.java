package makingSocial.view.HostModel_View;

import makingSocial.model.eventModel;
import makingSocial.model.session;
import makingSocial.model.userModel;
import makingSocial.view.UserProfile_View.homePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class printCode extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel codeLabel;
    private JTextArea summaryArea;
    private eventModel eventModel;

    public printCode(eventModel event) {
        this.eventModel = event;

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

        codeLabel = new JLabel(String.valueOf(event.getID_Event()));
        codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        codeLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
        codeLabel.setBounds(238, 133, 461, 73);
        contentPane.add(codeLabel);

        JLabel summaryTitle = new JLabel("Resumen de tu evento:");
        summaryTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
        summaryTitle.setBounds(113, 264, 259, 50);
        contentPane.add(summaryTitle);

        String resumenTexto = generarResumen(event);
        System.out.println("Resumen generado:\n" + resumenTexto);

        summaryArea = new JTextArea(resumenTexto);

        summaryArea = new JTextArea(generarResumen(event));
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
                userModel currentUser = session.getCurrentUser();
                new homePage().setVisible(true);
                dispose();
            }
        });

    }

    private String generarResumen(eventModel event) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Fecha: ").append(event.getDate()).append("\n");
        resumen.append("Hora: ").append(event.getSchedule()).append("\n");
        resumen.append("Dirección: ").append(event.getLocation()).append("\n");
        resumen.append("Código Postal: ").append(event.getPostalCode()).append("\n");
        resumen.append("Dress Code: ").append(event.isDressCode() ? "Sí" : "No").append("\n");
        if (event.isDressCode() && event.getDescription1() != null) {
            resumen.append("Descripción Dress Code: ").append(event.getDescription1()).append("\n");
        }
        resumen.append("Temática: ").append(event.isTheme() ? "Sí" : "No").append("\n");
        if (event.isTheme() && event.getDescription2() != null) {
            resumen.append("Descripción Temática: ").append(event.getDescription2()).append("\n");
        }
        resumen.append("Edad Permitida: ").append(event.getAllowedAge()).append("\n");
        resumen.append("Acceso: ").append(event.isAccess() ? "Privado" : "Público").append("\n");
        return resumen.toString();
    }

}
