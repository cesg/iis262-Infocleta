package cl.ufro.proyecto.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import cl.ufro.proyecto.beans.Alumno;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoInfFrame {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AlumnoInfFrame.class);
    private JFrame frame;
    private Alumno alumno;
    private JLabel lblNombre;
    private JLabel lblMatricula;
    private JLabel lblApellido;
    private JLabel lblNombreOut;
    private JLabel lblMatriculaOut;
    private JLabel lblApellidoOut;
    private JLabel lblDetalle;

    /**
     * Launch the application.
     */
    public static void main(final Alumno alumno) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlumnoInfFrame window = new AlumnoInfFrame();
                    if (alumno == null)
                        LOGGER.debug("## No se ha seleccionado un alumno para mostrar.");
                    window.setAlumno(alumno);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    LOGGER.error("## Error al iniciar el Frame", e);
                }
            }
        });
    }

    private void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        if (alumno != null) {
            lblNombreOut.setText(this.alumno.getNombre());
            lblMatriculaOut.setText(this.alumno.getMatricula());
            lblApellidoOut.setText(this.alumno.getApellidoPaterno());
        }
    }

    /**
     * Create the application.
     */
    public AlumnoInfFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 394, 235);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        /* lblNombre */
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(40, 62, 55, 14);
        frame.getContentPane().add(lblNombre);
        /* lblMatricula */
        lblMatricula = new JLabel("Matricula");
        lblMatricula.setBounds(40, 94, 55, 14);
        frame.getContentPane().add(lblMatricula);
        /* lblApellido */
        lblApellido = new JLabel("Apellido?");
        lblApellido.setBounds(40, 120, 55, 14);
        frame.getContentPane().add(lblApellido);
        /* lblNombreOut */
        lblNombreOut = new JLabel("");
        lblNombreOut.setBounds(107, 62, 200, 22);
        frame.getContentPane().add(lblNombreOut);
        /* lblMatriculaOut */
        lblMatriculaOut = new JLabel("");
        lblMatriculaOut.setBounds(107, 94, 200, 22);
        frame.getContentPane().add(lblMatriculaOut);
        /* lblApellidoOut */
        lblApellidoOut = new JLabel("");
        lblApellidoOut.setBounds(107, 120, 200, 22);
        frame.getContentPane().add(lblApellidoOut);
        /* lblDetalle */
        lblDetalle = new JLabel("DETALLE");
        lblDetalle.setBounds(40, 12, 267, 22);
        frame.getContentPane().add(lblDetalle);
    }
}
