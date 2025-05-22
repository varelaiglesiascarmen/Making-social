package makingSocial.view.GuestModel_View;

/*import makingSocial.DAO.GuestModel_DAO.SearchEventWCode_DAO;*/
import makingSocial.DAO.UserProfile_DAO.SignIn_DAO;
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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchEventWCode frame = new SearchEventWCode();
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
    public SearchEventWCode() {
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
                // llamar a la ventana Homepage
                HomePage homepage = new HomePage();
                homepage.setVisible(true);

                // disppuse() cierra la venta
                dispose();
            }
        });

        /*btnNewButtonAttend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el objeto del modelo
                UserModel exits = new UserModel(ID_Event);

                // Pasa el objeto usuario con sus datos
                boolean insert = false;
                insert = new SearchEventWCode_DAO().ejecutarInsertDeleteUpdate(exits);

                // si el codigo es correcto
                if(exits == true){
                    // si queda menos de media hora
                    if(){
                        // llamar a la ventana ProfileEditPhoto
                        profileEditPhoto photo = new profileEditPhoto();
                        photo.setVisible(true);

                        // disppuse() cierra la venta
                        dispose();
                    }else{
                        // llamar a la ventana EventFound
                        EventFound eventFound = new EventFound();
                        eventFound.setVisible(true);

                        // disppuse() cierra la venta
                        dispose();
                    }
                }
                // si el codigo no existe
                else{
                    // llamar a la ventana EventNotFound
                    EventNotFound eventNotFound = new EventNotFound();
                    eventNotFound.setVisible(true);

                    // disppuse() cierra la venta
                    dispose();
                }
            }
        });*/

    }

}
