/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.infocleta.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * 
 * @author kristian
 */
public class Propiedades {

	private static final String NOMBRE_ARCHIVO = "./rc.conf";
	private static final String KEY_LAF = "aplicacion.laf";
	private Logger LOG = LoggerFactory.getLogger(Propiedades.class);
	// private Configuration properties;
	private Properties prop;

	public Propiedades() {
		// URL fileUrl = Resources.getResource(NOMBRE_ARCHIVO);
		FileInputStream file = null;
		URL root = getClass().getProtectionDomain().getCodeSource()
		        .getLocation();
		URL filePath = null;
		try {
			filePath = new URL(root, NOMBRE_ARCHIVO);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		LOG.debug(filePath.getPath());
		try {
			file = new FileInputStream(filePath.getPath());
		} catch (FileNotFoundException e1) {
			LOG.error("# Error ", e1);
		}
		prop = new Properties();
		try {
			prop.load(file);
			file.close();
		} catch (IOException e) {
			LOG.error("# Error al leer el archivo de configuración", e);
		}
		// LOG.debug("Opciones cargadas del archivo : {}", fileUrl.toString());
		// try {
		// properties = new PropertiesConfiguration(NOMBRE_ARCHIVO);
		// } catch (ConfigurationException e) {
		// LOG.error("## Configuracion", e);
		// }
	}

	/**
	 * <p>
	 * Obtiene el <code>LookAndFeel</code> establecido en las propiedades.
	 * </p>
	 * <b>LAF getLookAndFeel()</b>
	 * 
	 * @return
	 */
	public Laf getLookAndFeel() {
		Laf laf = Laf.SYSTEM;
		if (prop == null)
			return laf;

		// String property = properties.getString(Llaves.LAF.toString());
		String property = prop.getProperty(KEY_LAF);

		if (property == null) {
			return laf;
		}
		laf = Ayudante.stringToLaf(property);
		return laf;
	}
}
