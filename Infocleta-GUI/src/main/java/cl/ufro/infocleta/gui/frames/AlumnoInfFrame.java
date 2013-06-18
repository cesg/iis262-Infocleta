/*
 * WindowBuilder 
 * */
package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import cl.ufro.infocleta.beans.Alumno;

import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlumnoInfFrame {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AlumnoInfFrame.class);
    private JFrame frame;
    private Alumno alumno;
    private JLabel lblNombre;
    private JLabel lblMatricula;
    private JLabel lblNombreOut;
    private JLabel lblMatriculaOut;
    private JLabel lblDetalle;
    private JButton btnAceptar;

    /**
     * Launch the application.
     */
    public static void iniciar(final Alumno alumno) {
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
        /* lblNombreOut */
        lblNombreOut = new JLabel("");
        lblNombreOut.setBounds(107, 62, 200, 22);
        frame.getContentPane().add(lblNombreOut);
        /* lblMatriculaOut */
        lblMatriculaOut = new JLabel("");
        lblMatriculaOut.setBounds(107, 94, 200, 22);
        frame.getContentPane().add(lblMatriculaOut);
        /* lblDetalle */
        lblDetalle = new JLabel("DETALLE");
        lblDetalle.setBounds(40, 12, 267, 22);
        frame.getContentPane().add(lblDetalle);
        /* ${component_name} */
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAceptarActionPerformed(e);
            }
        });
        btnAceptar.setBounds(107, 144, 98, 24);
        frame.getContentPane().add(btnAceptar);
    }

    protected void btnAceptarActionPerformed(ActionEvent e) {
        this.frame.dispose();
    }
}
