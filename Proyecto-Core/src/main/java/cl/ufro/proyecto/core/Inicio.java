/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import cl.ufro.proyecto.core.Enums.LAF;
import cl.ufro.proyecto.gui.ControladorGUI;
import cl.ufro.proyecto.gui.frames.Principal;
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
    /**
     * Contiene las propiedades establecidas
     */
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
            case JTATOO:
                setLookAndFeel(LAF.JTATOO.getValue());
                break;
            case SYSTEM:
            default:
                if (nombreSO().equalsIgnoreCase("Linux")) {
                    setLookAndFeel(LAF.SYSTEM_LINUX.getValue());
                } else {
                    setLookAndFeel(LAF.SYSTEM_WINDOWS.getValue());
                }
        }
    }
    
    private static void setLookAndFeel(String laf){
        try {
            UIManager.setLookAndFeel(laf);
            LOG.debug("LookAndFeel : {}",laf);
        } catch (ClassNotFoundException ex) {
            LOG.error(laf, ex);
        } catch (InstantiationException ex) {
            LOG.error(laf, ex);
        } catch (IllegalAccessException ex) {
            LOG.error(laf, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            LOG.error(laf, ex);
        }
    }
    
    public static String nombreSO() {
        return System.getProperty("os.name");
    }
}
