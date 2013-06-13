package cl.ufro.proyecto.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.gui.ControladorGUI;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarFrame {

    private JFrame frame;
    private static ControladorGUI controlador;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AgregarFrame.class);
    private JTextField txtFMatricula;
    private JTextField txtFNombre;

    /**
     * Launch the application.
     */
    public static void main(ControladorGUI controlador) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgregarFrame window = new AgregarFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        AgregarFrame.controlador = controlador;
    }

    /**
     * Create the application.
     */
    public AgregarFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMatricula = new JLabel("MATRICULA");
        lblMatricula.setBounds(63, 65, 92, 18);
        frame.getContentPane().add(lblMatricula);

        txtFMatricula = new JTextField();
        txtFMatricula.setBounds(173, 65, 200, 22);
        frame.getContentPane().add(txtFMatricula);
        txtFMatricula.setColumns(10);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(63, 110, 69, 16);
        frame.getContentPane().add(lblNombre);

        txtFNombre = new JTextField();
        txtFNombre.setBounds(173, 109, 200, 22);
        frame.getContentPane().add(txtFNombre);
        txtFNombre.setColumns(10);
    }
}
