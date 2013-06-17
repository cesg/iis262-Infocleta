package cl.ufro.proyecto.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.gui.ControladorGUI;
import cl.ufro.proyecto.gui.frames.utils.ErrorFrame;
import cl.ufro.proyecto.gui.frames.utils.InfoFrame;

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

    /**
     * Launch the application.
     */
    public static void iniciar(ControladorGUI controlador) {
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
        frame.setBounds(100, 100, 450, 266);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMatricula = new JLabel("MATRICULA");
        lblMatricula.setBounds(22, 67, 92, 18);
        frame.getContentPane().add(lblMatricula);

        txtFMatricula = new JTextField();
        txtFMatricula.setBounds(109, 65, 304, 22);
        frame.getContentPane().add(txtFMatricula);
        txtFMatricula.setColumns(10);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(22, 112, 69, 16);
        frame.getContentPane().add(lblNombre);

        txtFNombre = new JTextField();
        txtFNombre.setBounds(109, 109, 304, 22);
        frame.getContentPane().add(txtFNombre);
        txtFNombre.setColumns(10);
        /* btnAgregar */
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnAgregarActionPerformed(arg0);
            }
        });
        btnAgregar.setBounds(173, 174, 98, 24);
        frame.getContentPane().add(btnAgregar);
    }

    protected void btnAgregarActionPerformed(ActionEvent arg0) {
        String nombre = txtFNombre.getText();
        String matricual = txtFMatricula.getText();
        if (StringUtils.isNotEmpty(nombre) || StringUtils.isNotEmpty(matricual)) {
            Alumno a = new Alumno(nombre, matricual, null, null);
            controlador.agregarAlumno(a);
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ");
            sb.append(a.getNombre());
            sb.append("\n");
            sb.append("Matricula: ");
            sb.append(a.getMatricula());
            InfoFrame.iniciar("Alumno ingresado", sb.toString());
        } else {
            ErrorFrame.iniciar("Valores incorrectos", "Cadena vacia.");
        }

    }
}
