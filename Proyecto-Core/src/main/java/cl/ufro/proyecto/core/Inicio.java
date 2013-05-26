/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import cl.ufro.proyecto.core.Enums.LAF;
import cl.ufro.proyecto.gui.ControladorGUI;
import cl.ufro.proyecto.gui.frames.Principal;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kristian
 */
public class Inicio {
    private final static Propiedades PROPIEDADES = new Propiedades();
    private static LookAndFeel laf;
    private static final Logger LOG = LoggerFactory.getLogger(Inicio.class);

    public static void main(String arg[]) {
        final ControladorGUI controladorGUI = new SimpleControladorGUI();
        estiloVisual();
        Principal.iniciaNueva(controladorGUI);
    }

    private static void estiloVisual() {
        LAF lookAndFeel = PROPIEDADES.getLookAndFeel();
        switch (lookAndFeel) {
            case LAF_JTATOO:
                laf = new AeroLookAndFeel();
                LOG.debug("LAF: AeroLookAndFeel");
            case LAF_SYSTEM:
            default:
                if (nombreSO().equalsIgnoreCase("Linux")) {
                    laf = new GTKLookAndFeel();
                } else {
                    laf = new WindowsLookAndFeel();
                }
        }

        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            LOG.error("Error al establecer LAF.", ex);
        }
    }

    public static String nombreSO() {
        return System.getProperty("os.name");
    }
}
