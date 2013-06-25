package cl.ufro.infocleta.core.conf;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ayudante {
	private static Propiedades prop = new Propiedades();
	private static final Logger LOG = LoggerFactory.getLogger(Ayudante.class);
	public static final String SISTEMA_OP = System.getProperty("os.name");

	/**
	 * <p>
	 * Establece el estilo visual que tendra la aplicacion.
	 * </p>
	 * <b>iniciaEstiloVisual()</b>
	 */
	public static void iniciaEstiloVisual() {
		Laf proLaf = prop.getLookAndFeel();
		if (proLaf != null)
			setLookAndFeel(proLaf.toString());
	}

	private static void setLookAndFeel(final String laf) {
		try {
			UIManager.setLookAndFeel(laf);
			LOG.debug("LAF: {}", laf);
		} catch (ClassNotFoundException | InstantiationException
		        | IllegalAccessException | UnsupportedLookAndFeelException e) {
			LOG.error("## Eror al establecer el LookAndFeel", e);
		}
	}
}
