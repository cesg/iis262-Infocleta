package cl.ufro.infocleta.core.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.SystemUtils;

/**
 * <p>
 * Clase con utilitarios para la configuración
 * </p>
 * 
 * @author c3sg
 * 
 */
public class ConfUtils {

    protected ConfUtils() {
    }

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

    /**
     * <p>
     * Busca un archivo de propiedades utilizando el classLoader o la dirección
     * raiz del proyecto.
     * </p>
     * 
     * @param clazz
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Properties getProperties(Class<?> clazz, String fileName)
	    throws IOException {
	FileInputStream fis = null;
	File file = null;
	Properties prop = new Properties();
	ClassLoader clazzLoader = clazz.getClassLoader();
	URL fileUrl = clazzLoader.getResource(fileName);
	if (fileUrl != null) {
	    try {
		file = new File(fileUrl.toURI());
	    } catch (Exception e) {
		System.out.println(e);
	    }
	} else if (file == null || !file.exists()) {
	    String path = new File("").toURI().getPath();
	    file = new File(path, fileName);
	}

	if (file == null) {
	    System.out.println("No se logro encontrar el archivo.");
	    return null;
	}
	fis = new FileInputStream(file);
	System.out.println("Archivo encontrado: " + file.getAbsolutePath());
	prop.load(fis);
	if (fis != null)
	    fis.close();

	return prop;
    }
}
