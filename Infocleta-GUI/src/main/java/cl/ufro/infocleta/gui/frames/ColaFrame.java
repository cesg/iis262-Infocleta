package cl.ufro.infocleta.gui.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.gui.ControladorGUI;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ColaFrame {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ColaFrame.class);
    private static ControladorGUI controlador;
    private JFrame frame;
    private JList list;
    private JButton btnAgregar;
    private JButton btnFinalizar;

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
        frame = new JFrame();
        frame.setBounds(100, 100, 355, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        list = new JList();
        list.setBounds(12, 36, 160, 322);
        frame.getContentPane().add(list);
        /* ${component_name} */
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(184, 282, 98, 24);
        frame.getContentPane().add(btnAgregar);
        /* ${component_name} */
        btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBounds(184, 333, 98, 24);
        frame.getContentPane().add(btnFinalizar);
    }
}
