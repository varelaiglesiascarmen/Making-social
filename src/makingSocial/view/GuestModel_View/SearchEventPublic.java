package makingSocial.view.GuestModel_View;

import makingSocial.DAO.GuestModel_DAO.SearchEventPublic_DAO;
import makingSocial.DAO.UserProfile_DAO.SignIn_DAO;
import makingSocial.model.EventModel;
import makingSocial.model.UserModel;
import makingSocial.view.UserProfile_View.HomePage;
import makingSocial.view.UserProfile_View.replicatedUser;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEventPublic extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchEventPublic frame = new SearchEventPublic();
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
        titlePostalCode.setBounds(171, 56, 658, 73);
        contentPane.add(titlePostalCode);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 45));
        textField.setBounds(151, 139, 730, 57);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel AttendEvent = new JLabel("Lorem ipsum dolor sit amet");
        AttendEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        AttendEvent.setBounds(150, 242, 610, 33);
        contentPane.add(AttendEvent);

        JButton btnNewButtonAttend = new JButton("Asistir");
        btnNewButtonAttend.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButtonAttend.setBounds(770, 240, 111, 36);
        contentPane.add(btnNewButtonAttend);

        JButton btnGoHomePage = new JButton("Volver a inicio");
        btnGoHomePage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGoHomePage.setBounds(784, 606, 140, 30);
        contentPane.add(btnGoHomePage);

        btnNewButtonAttend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuidado: los JPasswordField devuelven char[], hay que convertirlos
                int PostalCode = Integer.parseInt(textField.getText());

                // Crear el objeto del modelo
                //EventModel event = new EventModel(PostalCode);

                // Pasa el objeto usuario con sus datos
                boolean insert = false;
                //insert = new SearchEventPublic_DAO().ejecutarInsertDeleteUpdate(event);

                if( insert == true){
                    /* Si encuentra algun evento debe mostrar en Lorem Ipsum los datos
                    *
                    * Por cada evento debe poder seleccionar "Asistir" que lo llevará a ProfileEditPhoto
                    *
                    * */
                }
                // Si no, vuelve a decirle que rellene el formulario
                else {
                    /* Si no encuentra eventos debe mostrar en Lorem Ipsum "No hay eventos en tu ciudad" */

                }
            }
        });

        btnGoHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

    }
}
