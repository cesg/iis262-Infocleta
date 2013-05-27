/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import cl.ufro.proyecto.core.Enums.LAF;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kristian
 */
public class Propiedades extends ArchivoPropiedades {

    private Properties prop;
    private URL fileProp;
    private Logger LOG = LoggerFactory.getLogger(Propiedades.class);

    public Propiedades() {
        this.prop = new Properties();
        fileProp = getClass().getClassLoader().getResource(NOMBRE);
        try {
            if (direccion != null) {
                this.prop.load(direccion.openStream());
            }
        } catch (IOException ex) {
            LOG.error("Error", ex);
        }
    }

    public LAF getLookAndFeel() {
        String property = prop.getProperty(KEY_LAF);
//TODO: switch
        return LAF.LAF_JTATOO;
    }
}
