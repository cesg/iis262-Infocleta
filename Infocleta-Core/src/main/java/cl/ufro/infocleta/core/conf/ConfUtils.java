package cl.ufro.infocleta.core.conf;

import org.apache.commons.lang3.SystemUtils;

public class ConfUtils {

	/**
	 * <p>
	 * Se encarga de asociar un valor de la propiedad
	 * <code>aplicacion.laf</code> a un LookAndFeel soportado por la aplicacion.
	 * </p>
	 * <b>Laf stringToLaf (String prop)</b>
	 * 
	 * @param prop
	 *            propiedad obtenida.
	 * @return el LookAndFeel asociado.
	 */
	public static Laf stringToLaf(String prop) {
		Laf laf = Laf.DEFAULT;
		switch (prop) {
		case "seaglass":
			laf = Laf.SEAGLASS;
			break;
		case "web":
			laf = Laf.WEB;
			break;
		case "sistema":
			if (SystemUtils.IS_OS_LINUX)
				laf = Laf.SYSTEM_LINUX;
			else if (SystemUtils.IS_OS_WINDOWS)
				laf = Laf.SYSTEM_WINDOWS;
			break;
		default:
			break;
		}
		return laf;
	}
}
