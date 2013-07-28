package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Queue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.UtilidadesGui;

public class ColaFrame {

    private Image appIcon;
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(ColaFrame.class);
    private static ControladorGUI controlador;
    private JFrame frame;
    private JList<Alumno> list;
    private JButton btnAgregar;
    private JButton btnFinalizar;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void iniciar(final ControladorGUI controlador) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ColaFrame window = new ColaFrame();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    LOGGER.error("# Error al inciar el frame.", e);
		}
	    }
	});
	ColaFrame.controlador = controlador;
    }

    private void actualizarLista() {
	DefaultListModel<Alumno> model = new DefaultListModel<>();
	Queue<Alumno> alumnos = controlador.obtenerAlumnosEnCola();
	for (Alumno alumno : alumnos) {
	    model.addElement(alumno);
	}
	this.list.setModel(model);
	this.list.validate();
    }

    /**
     * Create the application.
     */
    public ColaFrame() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	appIcon = UtilidadesGui.obtenerAppImg();
	frame = new JFrame();
	frame.addWindowFocusListener(new WindowFocusListener() {
	    public void windowGainedFocus(WindowEvent arg0) {
		frameWindowGainedFocus(arg0);
	    }

	    public void windowLostFocus(WindowEvent arg0) {
	    }
	});
	frame.setBounds(100, 100, 355, 428);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setIconImage(appIcon);
	/* scrollPane */
	scrollPane = new JScrollPane();
	scrollPane.setBounds(12, 36, 160, 322);
	frame.getContentPane().add(scrollPane);
	list = new JList<Alumno>();
	scrollPane.setViewportView(list);
	/* btnAgregar */
	btnAgregar = new JButton("Agregar");
	btnAgregar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnAgregarActionPerformed(e);
	    }
	});
	btnAgregar.setBounds(184, 282, 98, 24);
	frame.getContentPane().add(btnAgregar);
	/* btnFinalizar */
	btnFinalizar = new JButton("Finalizar");
	btnFinalizar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnFinalizarActionPerformed(e);
	    }
	});
	btnFinalizar.setBounds(184, 333, 98, 24);
	frame.getContentPane().add(btnFinalizar);
    }

    protected void btnAgregarActionPerformed(ActionEvent e) {
	AgregarFrame.iniciar(controlador, this);
    }

    protected void btnFinalizarActionPerformed(ActionEvent e) {
	this.frame.dispose();
    }

    protected void frameWindowGainedFocus(WindowEvent arg0) {
	actualizarLista();
    }
}
