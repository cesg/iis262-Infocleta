/*
 * WindowBuilder 
 * */
package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.UtilidadesGui;

public class AgregarFrame {

    private Image appIcon;
    private JFrame frame;
    private static ControladorGUI controlador;
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(AgregarFrame.class);
    private JTextField txtFMatricula;
    private JTextField txtFNombre;
    private JButton btnAgregar;
    private JCheckBox chckbxMantener;

    /**
     * Launch the application.
     */
    public static void iniciar(ControladorGUI controlador, final Object sender) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AgregarFrame window = new AgregarFrame(sender);
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
    public AgregarFrame(Object sender) {
	initialize();
	if (sender instanceof ColaFrame) {
	    this.txtFNombre.setEnabled(false);
	}
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	this.appIcon = UtilidadesGui.obtenerAppImg();
	frame = new JFrame();
	frame.setIconImage(appIcon);
	frame.setResizable(false);
	frame.setBounds(100, 100, 450, 227);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);

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
	btnAgregar.setBounds(109, 157, 98, 24);
	frame.getContentPane().add(btnAgregar);

	chckbxMantener = new JCheckBox("Mantener");
	chckbxMantener.setBounds(301, 158, 92, 22);
	frame.getContentPane().add(chckbxMantener);
    }

    protected void btnAgregarActionPerformed(ActionEvent arg0) {
	String nombre = txtFNombre.getText();
	String matricual = txtFMatricula.getText();
	if (this.txtFNombre.isEnabled() && StringUtils.isNotEmpty(nombre)
	        && StringUtils.isNotEmpty(matricual)) {
	    Alumno a = new Alumno(nombre, matricual, null, null);
	    controlador.agregarAlumno(a);

	} else if (!this.txtFNombre.isEnabled()
	        && StringUtils.isNotEmpty(matricual)) {
	    Alumno a = new Alumno(null, matricual, null, null);
	    controlador.agregarACola(a);
	}
	txtFMatricula.setText("");
	txtFMatricula.setText("");
	if (!chckbxMantener.isSelected())
	    this.frame.dispose();
    }
}
