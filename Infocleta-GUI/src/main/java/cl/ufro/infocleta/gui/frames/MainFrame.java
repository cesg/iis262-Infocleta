/*
 * WindowBuilder 
 * */
package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;
import cl.ufro.infocleta.gui.ControladorGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class MainFrame {

    private JFrame frame;
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

    /**
     * Launch the application.
     */
    public static void iniciar(ControladorGUI controlador) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    LOGGER.error("## Error al iniciar el JFrame", e);
                }
            }
        });
        MainFrame.controlador = controlador;
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
        frame = new JFrame();
        frame.setBounds(100, 100, 488, 592);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 62, 163, 395);
        frame.getContentPane().add(scrollPane);

        list = new JList<>();
        scrollPane.setViewportView(list);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAgregarActionPerformed(e);
            }
        });
        btnAgregar.setBounds(248, 494, 98, 24);
        frame.getContentPane().add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnEliminarActionPerformed(arg0);
            }
        });
        btnEliminar.setBounds(358, 494, 98, 24);
        frame.getContentPane().add(btnEliminar);

        lblListaAlumnos = new JLabel("LISTA ALUMNOS");
        lblListaAlumnos.setBounds(28, 46, 163, 14);
        frame.getContentPane().add(lblListaAlumnos);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnActualizarActionPerformed(arg0);
            }
        });
        btnActualizar.setBounds(138, 494, 98, 24);
        frame.getContentPane().add(btnActualizar);
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
        frame.getContentPane().add(btnDetalle);
        /* internalFrame */
        internalFrame = new JInternalFrame("Detalle");
        internalFrame.setBorder(UIManager
                .getBorder("InternalFrame.paletteBorder"));
        internalFrame.setResizable(true);
        internalFrame.setBounds(224, 62, 228, 270);
        frame.getContentPane().add(internalFrame);
        internalFrame.getContentPane().setLayout(null);
        /* lblNombre */
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(12, 24, 55, 14);
        internalFrame.getContentPane().add(lblNombre);
        /* lblNombreout */
        lblNombreout = new JLabel("");
        lblNombreout.setBounds(12, 50, 194, 20);
        internalFrame.getContentPane().add(lblNombreout);
        /* lblMatricula */
        lblMatricula = new JLabel("Matricula");
        lblMatricula.setBounds(12, 93, 83, 20);
        internalFrame.getContentPane().add(lblMatricula);
        /* lblMatriculaout */
        lblMatriculaout = new JLabel("");
        lblMatriculaout.setBounds(12, 125, 194, 20);
        internalFrame.getContentPane().add(lblMatriculaout);
        internalFrame.setVisible(true);
    }

    protected void btnAgregarActionPerformed(ActionEvent e) {
        AgregarFrame.iniciar(controlador);
    }

    protected void btnDetalleActionPerformed(ActionEvent arg0) {
        Alumno alumno = list.getSelectedValue();
        if (alumno != null) {
            lblNombreout.setText(alumno.getNombre());
            lblMatriculaout.setText(alumno.getMatricula());
        }
        // AlumnoInfFrame.iniciar(list.getSelectedValue());
    }

    protected void btnActualizarActionPerformed(ActionEvent arg0) {
        ListaAlumnos listaAlumnos = controlador.todosAlumnos();
        listModel.clear();
        for (Alumno alumno : listaAlumnos) {
            listModel.addElement(alumno);
        }
        list.revalidate();
    }

    protected void btnEliminarActionPerformed(ActionEvent arg0) {
        Alumno a = list.getSelectedValue();
        if (a != null)
            controlador.borrarAlumno(a);
    }
}
