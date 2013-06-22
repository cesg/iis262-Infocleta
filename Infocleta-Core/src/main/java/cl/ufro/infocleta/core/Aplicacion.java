package cl.ufro.infocleta.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.frames.MainFrame;

/**
 *
 * @author kristian
 */
public class Aplicacion {
    private static final Logger LOG = LoggerFactory.getLogger(Aplicacion.class);

    public static void main(String arg[]) {
        LOG.debug("## Iniciando la aplicacion.");
        final ControladorGUI controladorGUI = new SimpleControladorGUI();
        Ayudante.iniciaEstiloVisual();
       MainFrame.iniciar(controladorGUI);
    } 
}
