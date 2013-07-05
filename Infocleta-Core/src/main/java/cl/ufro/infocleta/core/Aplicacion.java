package cl.ufro.infocleta.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.core.conf.Ayudante;
import cl.ufro.infocleta.gui.ControladorGUI;
import cl.ufro.infocleta.gui.frames.InicioFrame;

/**
 * <p>
 * Clase principal de Infocleta, aquí se inicia la aplicación.
 * </p>
 * 
 * @author c3sg
 */
public class Aplicacion {
	private static final Logger LOG = LoggerFactory.getLogger(Aplicacion.class);

	public static void main(String arg[]) {
		LOG.debug("## Iniciando la aplicacion.");
		final ControladorGUI controladorGUI = new ControladorGUIImp();
		Ayudante.iniciaEstiloVisual();
		new Thread(new InicioFrame(controladorGUI)).start();
	}
}
