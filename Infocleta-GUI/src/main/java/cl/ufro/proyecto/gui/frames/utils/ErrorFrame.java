package cl.ufro.proyecto.gui.frames.utils;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorFrame {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ErrorFrame.class);
    private JFrame frame;
    private JLabel lblError;
    private JLabel label;
    private JLabel lblDetalle;
    private JTextArea textArea;
    private JButton btnAceptar;

    /**
     * Launch the application.
     */
    public static void iniciar(final String causa, final String detalle) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ErrorFrame window = new ErrorFrame(causa, detalle);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    LOGGER.error("Error al inciar el frame", e);
                }
            }
        });
    }

    /**
     * Create the application.
     */
    protected ErrorFrame(String causa, String detalle) {
        initialize();
        this.label.setText(causa);
        this.textArea.setText(detalle);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        /* lblError */
        lblError = new JLabel("ERROR:");
        lblError.setBounds(34, 46, 55, 20);
        frame.getContentPane().add(lblError);
        /* label */
        label = new JLabel("");
        label.setBounds(101, 49, 272, 20);
        frame.getContentPane().add(label);
        /* lblDetalle */
        lblDetalle = new JLabel("DETALLE:");
        lblDetalle.setBounds(34, 81, 74, 20);
        frame.getContentPane().add(lblDetalle);
        /* textArea */
        textArea = new JTextArea();
        textArea.setBounds(34, 103, 339, 76);
        frame.getContentPane().add(textArea);
        /* btnAceptar */
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnAceptarActionPerformed(arg0);
            }
        });
        btnAceptar.setBounds(34, 191, 98, 24);
        frame.getContentPane().add(btnAceptar);
    }

    protected void btnAceptarActionPerformed(ActionEvent arg0) {
        this.frame.dispose();
    }
}
