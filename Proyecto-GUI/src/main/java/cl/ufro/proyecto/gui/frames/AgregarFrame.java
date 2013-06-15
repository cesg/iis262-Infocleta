package cl.ufro.proyecto.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.gui.ControladorGUI;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarFrame {

    private JFrame frame;
    private static ControladorGUI controlador;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AgregarFrame.class);
    private JTextField txtFMatricula;
    private JTextField txtFNombre;
    private JButton btnAgregar;
    private JLabel lblApellido;
    private JTextField textField;

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
                    LOGGER.error("## Error al iniciar el frame", e);
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        /* btnAgregar */
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnAgregarActionPerformed(arg0);
            }
        });
        btnAgregar.setBounds(173, 214, 98, 24);
        frame.getContentPane().add(btnAgregar);
        /* lblApellido */
        lblApellido = new JLabel("APELLIDO");
        lblApellido.setBounds(63, 152, 92, 18);
        frame.getContentPane().add(lblApellido);
        /* textField */
        textField = new JTextField();
        textField.setBounds(173, 150, 200, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
    }

    protected void btnAgregarActionPerformed(ActionEvent arg0) {
        String nombre = txtFNombre.getText();
        String matricual = txtFMatricula.getText();
        if (StringUtils.isNotEmpty(nombre) || StringUtils.isNotEmpty(matricual)) {
            Alumno a = new Alumno(nombre, matricual, null, null);
            controlador.agregarAlumno(a);
        }

    }
}
