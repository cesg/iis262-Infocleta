/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p></p>
 * @author kristian
 */
public class Propiedades {

    private static final String NOMBRE_ARCHIVO = "Aplicacion.conf";
    private Logger LOG = LoggerFactory.getLogger(Propiedades.class);
    private PropertiesConfiguration properties;

    public Propiedades() {
        try {
            properties = new PropertiesConfiguration(NOMBRE_ARCHIVO);
            properties.load();
        } catch (ConfigurationException e) {
            LOG.error("## Configuracion", e);
        }
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
        if (properties == null)
            return laf;

        String property = properties.getString(Llaves.LAF.toString());

        if (property == null) {
            return laf;
        }
        laf = Ayudante.stringToLaf(property);
        return laf;
    }
}
