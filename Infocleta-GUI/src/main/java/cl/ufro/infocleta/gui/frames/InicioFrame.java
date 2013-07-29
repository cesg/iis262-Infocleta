package cl.ufro.infocleta.gui.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.UtilidadesGui;

public class InicioFrame extends JFrame implements Runnable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblBackground;
    private ControladorGUI contGui;
    private JLabel lblV;
    private JLabel lblIniciando;

    // /**
    // * Launch the application.
    // */
    // public static void main(String[] args) {
    // EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // try {
    // InicioFrame frame = new InicioFrame();
    // frame.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    // }

    /**
     * Create the frame.
     */
    public InicioFrame(ControladorGUI contGui) {
	this.contGui = contGui;
	setUndecorated(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 400, 240);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	lblV = new JLabel("V1.5");
	lblV.setBounds(342, 214, 45, 20);
	contentPane.add(lblV);

	lblIniciando = new JLabel("INICIANDO...");
	lblIniciando.setBounds(24, 214, 150, 20);
	contentPane.add(lblIniciando);

	lblBackground = new JLabel("");
	lblBackground.setBounds(0, 0, 400, 240);
	contentPane.add(lblBackground);
	lblBackground.setIcon(UtilidadesGui.obtenerInicioImg());

	this.setLocationRelativeTo(null);
    }

    @Override
    public void run() {
	try {
	    this.setVisible(true);
	    Thread.sleep(3000);
	    MainFrame.iniciar(contGui);
	    this.dispose();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
