package cl.ufro.proyecto.gui.frames;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;
import cl.ufro.proyecto.gui.ControladorGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        frame.setBounds(100, 100, 413, 477);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 62, 163, 321);
        frame.getContentPane().add(scrollPane);

        list = new JList<>();
        scrollPane.setViewportView(list);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAgregarActionPerformed(e);
            }
        });
        btnAgregar.setBounds(244, 359, 98, 24);
        frame.getContentPane().add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(244, 325, 98, 24);
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
        btnActualizar.setBounds(244, 289, 98, 24);
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
        btnDetalle.setBounds(244, 259, 98, 24);
        frame.getContentPane().add(btnDetalle);
    }

    protected void btnAgregarActionPerformed(ActionEvent e) {
        AgregarFrame.iniciar(controlador);
    }

    protected void btnDetalleActionPerformed(ActionEvent arg0) {
        AlumnoInfFrame.iniciar(list.getSelectedValue());
    }

    protected void btnActualizarActionPerformed(ActionEvent arg0) {
        ListaAlumnos listaAlumnos = controlador.todosAlumnos();
        listModel.clear();
        for (Alumno alumno : listaAlumnos) {
            listModel.addElement(alumno);
        }
        list.revalidate();
    }
}
