package cl.ufro.infocleta.gui.frames.utils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoFrame {
    private static Logger LOGGER = LoggerFactory.getLogger(InfoFrame.class);
    private JFrame frmInformacin;
    private JLabel lblInfo;
    private JLabel lblInfoOut;
    private JLabel lblDetalle;
    private JTextArea textArea;
    private JButton btnAceptar;

    /**
     * Launch the application.
     */
    public static void iniciar(final String info, final String detalle) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoFrame window = new InfoFrame(info, detalle);
                    window.frmInformacin.setVisible(true);
                } catch (Exception e) {
                    LOGGER.error("# Error al iniciar el frame", e);
                }
            }
        });
    }

    /**
     * Create the application.
     */
    protected InfoFrame(String info, String detalle) {
        initialize();
        frmInformacin.setLocationRelativeTo(null);
        this.lblInfoOut.setText(info);
        this.textArea.setText(detalle);
        /* ${component_name} */
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnAceptarActionPerformed(arg0);
            }
        });
        btnAceptar.setBounds(26, 200, 98, 24);
        frmInformacin.getContentPane().add(btnAceptar);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmInformacin = new JFrame();
        frmInformacin.setTitle("INFORMACIÓN");
        frmInformacin.setResizable(false);
        frmInformacin.setBounds(100, 100, 450, 293);
        frmInformacin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmInformacin.getContentPane().setLayout(null);
        /* lblInfo */
        lblInfo = new JLabel("INFO");
        lblInfo.setBounds(26, 12, 55, 20);
        frmInformacin.getContentPane().add(lblInfo);
        /* lblInfoOut */
        lblInfoOut = new JLabel("");
        lblInfoOut.setBounds(100, 12, 323, 20);
        frmInformacin.getContentPane().add(lblInfoOut);
        /* lblDetalle */
        lblDetalle = new JLabel("DETALLE");
        lblDetalle.setBounds(26, 61, 70, 20);
        frmInformacin.getContentPane().add(lblDetalle);
        /* textArea */
        textArea = new JTextArea();
        textArea.setBounds(26, 93, 386, 95);
        frmInformacin.getContentPane().add(textArea);
    }

    protected void btnAceptarActionPerformed(ActionEvent arg0) {
        this.frmInformacin.dispose();
    }
}
