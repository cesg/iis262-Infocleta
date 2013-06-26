/*
 * WindowBuilder 
 * */
package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.UtilidadesGui;

public class MainFrame {
	private Image appImage;
	private JFrame frmInfocleta;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JLabel lblListaAlumnos;
	private JButton btnActualizar;
	private JList<Alumno> list;
	private DefaultListModel<Alumno> listModel;
	private static ControladorGUI controlador;
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(MainFrame.class);
	private JButton btnDetalle;
	private JInternalFrame internalFrame;
	private JLabel lblNombre;
	private JLabel lblNombreout;
	private JLabel lblMatricula;
	private JLabel lblMatriculaout;
	private JMenuBar menuBar;
	private JMenu mnAyuda;
	private JMenuItem mntmAcerca;
	private JMenu mnUtilidades;
	private JMenuItem mntmAgregarCola;
	private JLabel labelVersion;
	private JMenuItem mntmVaciarCola;
	private JLabel lblAlumnosEnCola;
	private JLabel lblColaOut;

	/**
	 * Launch the application.
	 */
	public static void iniciar(ControladorGUI controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmInfocleta.setVisible(true);
				} catch (Exception e) {
					LOGGER.error("## Error al iniciar el JFrame", e);
				}
			}
		});
		MainFrame.controlador = controlador;
	}

	public void mostrarDetalle(Alumno a) {
		this.lblNombreout.setText(a.getNombre());
		this.lblMatriculaout.setText(a.getMatricula());
	}

	private void actualizarCola(){
		lblColaOut.setText(StringUtils.EMPTY+controlador.alumnosEnCola());
	}
	
	private void actualizarLista() {
		DefaultListModel<Alumno> model = new DefaultListModel<>();
		for (Alumno alumno : controlador.todosAlumnos()) {
			model.addElement(alumno);
		}
		this.list.setModel(model);
		this.list.validate();
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		appImage = UtilidadesGui.obtenerAppImg();
		frmInfocleta = new JFrame();
		frmInfocleta.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				frmInfocletaWindowGainedFocus(arg0);
			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frmInfocleta.setTitle("Infocleta");
		frmInfocleta.setBounds(100, 100, 623, 580);
		frmInfocleta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInfocleta.getContentPane().setLayout(null);
		frmInfocleta.setLocationRelativeTo(null);
		frmInfocleta.setIconImage(appImage);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 62, 222, 395);
		frmInfocleta.getContentPane().add(scrollPane);

		list = new JList<>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMouseClicked(e);
			}
		});
		scrollPane.setViewportView(list);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActionPerformed(e);
			}
		});
		btnAgregar.setBounds(248, 494, 98, 24);
		frmInfocleta.getContentPane().add(btnAgregar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarActionPerformed(arg0);
			}
		});
		btnEliminar.setBounds(358, 494, 98, 24);
		frmInfocleta.getContentPane().add(btnEliminar);

		lblListaAlumnos = new JLabel("LISTA ALUMNOS");
		lblListaAlumnos.setBounds(28, 46, 163, 14);
		frmInfocleta.getContentPane().add(lblListaAlumnos);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnActualizarActionPerformed(arg0);
			}
		});
		btnActualizar.setBounds(138, 494, 98, 24);
		frmInfocleta.getContentPane().add(btnActualizar);
		listModel = new DefaultListModel<>();
		this.list.setModel(listModel);
		/* btnDetalle */
		btnDetalle = new JButton("Detalle");
		btnDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDetalleActionPerformed(arg0);
			}
		});
		btnDetalle.setBounds(28, 494, 98, 24);
		frmInfocleta.getContentPane().add(btnDetalle);
		/* internalFrame */
		internalFrame = new JInternalFrame("Detalle");
		internalFrame.setResizable(true);
		internalFrame.setBorder(UIManager
		        .getBorder("InternalFrame.paletteBorder"));
		internalFrame.setBounds(295, 62, 228, 163);
		frmInfocleta.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		/* lblNombre */
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 55, 20);
		internalFrame.getContentPane().add(lblNombre);
		/* lblNombreout */
		lblNombreout = new JLabel("");
		lblNombreout.setBounds(12, 32, 194, 20);
		internalFrame.getContentPane().add(lblNombreout);
		/* lblMatricula */
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(12, 64, 83, 20);
		internalFrame.getContentPane().add(lblMatricula);
		/* lblMatriculaout */
		lblMatriculaout = new JLabel("");
		lblMatriculaout.setBounds(12, 83, 194, 20);
		internalFrame.getContentPane().add(lblMatriculaout);
		/* menuBar */
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 621, 21);
		frmInfocleta.getContentPane().add(menuBar);
		/* mnUtilidades */
		mnUtilidades = new JMenu("Utilidades");
		menuBar.add(mnUtilidades);
		/* mntmAgregarCola */
		mntmAgregarCola = new JMenuItem("Agregar Cola");
		mntmAgregarCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mntmAgregarColaActionPerformed(arg0);
			}
		});
		mnUtilidades.add(mntmAgregarCola);
		
		mntmVaciarCola = new JMenuItem("Vaciar Cola");
		mntmVaciarCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mntmVaciarColaActionPerformed(arg0);
			}
		});
		mnUtilidades.add(mntmVaciarCola);
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		/* mntmAcerca*/
		mntmAcerca = new JMenuItem("Acerca");
		mnAyuda.add(mntmAcerca);
		
		labelVersion = new JLabel("1.3");
		labelVersion.setBounds(554, 528, 55, 14);
		frmInfocleta.getContentPane().add(labelVersion);
		
		lblAlumnosEnCola = new JLabel("Alumnos en cola");
		lblAlumnosEnCola.setBounds(295, 406, 112, 20);
		frmInfocleta.getContentPane().add(lblAlumnosEnCola);
		
		lblColaOut = new JLabel("0");
		lblColaOut.setBounds(419, 406, 55, 20);
		frmInfocleta.getContentPane().add(lblColaOut);
		internalFrame.setVisible(true);
	}

	protected void btnAgregarActionPerformed(ActionEvent e) {
		AgregarFrame.iniciar(controlador, true);
	}

	protected void btnDetalleActionPerformed(ActionEvent arg0) {
		Alumno alumno = list.getSelectedValue();
		if (alumno != null) {
			mostrarDetalle(alumno);
		}
		// AlumnoInfFrame.iniciar(list.getSelectedValue());
	}

	protected void btnActualizarActionPerformed(ActionEvent arg0) {
		actualizarLista();
	}

	protected void btnEliminarActionPerformed(ActionEvent arg0) {
		Alumno a = list.getSelectedValue();
		if (a != null)
			controlador.borrarAlumno(a);
		actualizarLista();
	}

	protected void listMouseClicked(MouseEvent e) {
		Alumno a = list.getSelectedValue();
		if (a != null) {
			mostrarDetalle(a);
		}
	}

	protected void mntmAgregarColaActionPerformed(ActionEvent arg0) {
		ColaFrame.iniciar(controlador);
	}

	protected void frmInfocletaWindowGainedFocus(WindowEvent arg0) {
		actualizarLista();
		actualizarCola();
	}
	protected void mntmVaciarColaActionPerformed(ActionEvent arg0) {
		controlador.vaciarCola();
		actualizarCola();
	}
}
