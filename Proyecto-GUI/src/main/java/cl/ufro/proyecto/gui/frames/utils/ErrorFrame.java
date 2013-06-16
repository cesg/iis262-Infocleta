package cl.ufro.proyecto.gui.frames.utils;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ErrorFrame {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(final String causa, final String detalle) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ErrorFrame window = new ErrorFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ErrorFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
