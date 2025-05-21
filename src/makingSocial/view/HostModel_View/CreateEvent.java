package makingSocial.view.HostModel_View;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class CreateEvent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldDirection;
    private JTextField textFieldCodePost;
    private JTextField textFieldYesDressCode;
    private JTextField textField;
    private JTextField textTheme;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateEvent frame = new CreateEvent();
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
    public CreateEvent() {
        setTitle("Making Social!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 807, 731);
        getContentPane().setLayout(null);

        JLabel protocoloEvent = new JLabel("Añade el protocolo de tu evento:");
        protocoloEvent.setFont(new Font("Tahoma", Font.BOLD, 30));
        protocoloEvent.setBounds(55, 41, 511, 54);
        getContentPane().add(protocoloEvent);

        ImageIcon icon = new ImageIcon(getClass().getResource("/makingSocial/src/img/logoPequeno.png"));
        setIconImage(icon.getImage());

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setToolTipText("");
        dateChooser.setBounds(281, 129, 362, 35);
        getContentPane().add(dateChooser);

        textFieldDirection = new JTextField();
        textFieldDirection.setBounds(281, 174, 362, 35);
        getContentPane().add(textFieldDirection);
        textFieldDirection.setColumns(10);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Si");
        rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNewRadioButton.setBounds(400, 277, 103, 21);
        getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNo = new JRadioButton("No");
        rdbtnNo.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNo.setBounds(505, 277, 103, 21);
        getContentPane().add(rdbtnNo);

        textFieldCodePost = new JTextField();
        textFieldCodePost.setColumns(10);
        textFieldCodePost.setBounds(462, 223, 181, 35);
        getContentPane().add(textFieldCodePost);

        JLabel lblDate = new JLabel("Fecha");
        lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDate.setBounds(90, 129, 181, 35);
        getContentPane().add(lblDate);

        JLabel lblDirection = new JLabel("Dirección");
        lblDirection.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDirection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDirection.setBounds(90, 174, 181, 35);
        getContentPane().add(lblDirection);

        JLabel lblCodePostal = new JLabel("Código Postal");
        lblCodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCodePostal.setBounds(271, 223, 181, 35);
        getContentPane().add(lblCodePostal);

        textFieldYesDressCode = new JTextField();
        textFieldYesDressCode.setColumns(10);
        textFieldYesDressCode.setBounds(400, 311, 243, 35);
        getContentPane().add(textFieldYesDressCode);

        JLabel lblDressCode = new JLabel("¿Tu fiesta tiene dress code?");
        lblDressCode.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDressCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDressCode.setBounds(112, 270, 285, 35);
        getContentPane().add(lblDressCode);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(281, 356, 362, 35);
        getContentPane().add(textField);

        JLabel lblEdadPermitida = new JLabel("Edad permitida");
        lblEdadPermitida.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEdadPermitida.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEdadPermitida.setBounds(90, 356, 181, 35);
        getContentPane().add(lblEdadPermitida);

        JLabel lblTheme = new JLabel("¿Tu fiesta tiene alguna temática?  ");
        lblTheme.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTheme.setBounds(10, 416, 400, 35);
        getContentPane().add(lblTheme);

        JRadioButton rdbtnYesTheme = new JRadioButton("Si");
        rdbtnYesTheme.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnYesTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnYesTheme.setBounds(403, 427, 103, 21);
        getContentPane().add(rdbtnYesTheme);

        JRadioButton rdbtnNoTheme = new JRadioButton("No");
        rdbtnNoTheme.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNoTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNoTheme.setBounds(508, 427, 103, 21);
        getContentPane().add(rdbtnNoTheme);

        textTheme = new JTextField();
        textTheme.setColumns(10);
        textTheme.setBounds(400, 459, 243, 35);
        getContentPane().add(textTheme);

        JLabel lblAccess = new JLabel("El acceso al evento es:");
        lblAccess.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAccess.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccess.setBounds(10, 504, 400, 35);
        getContentPane().add(lblAccess);

        JRadioButton rdbtnYesPublic = new JRadioButton("Público");
        rdbtnYesPublic.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnYesPublic.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnYesPublic.setBounds(371, 559, 103, 21);
        getContentPane().add(rdbtnYesPublic);

        JRadioButton rdbtnNoPrivate = new JRadioButton("Privado");
        rdbtnNoPrivate.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNoPrivate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rdbtnNoPrivate.setBounds(505, 559, 103, 21);
        getContentPane().add(rdbtnNoPrivate);

        JButton btnSave = new JButton("Guardar evento");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBounds(285, 610, 218, 33);
        getContentPane().add(btnSave);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton btnOK = new JButton("Confirmar");
        btnOK.setBounds(387, 461, 140, 29);
        contentPane.add(btnOK);


    }
}
