/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import cl.ufro.proyecto.core.Enums.LAF;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kristian
 */
public class Propiedades extends ArchivoPropiedades {
    private Properties prop;
    private URL fileProp;
//    private String nombreArchivo = "Proyecto.conf";
    
    public Propiedades(){
    this.prop = new Properties();
        fileProp = getClass().getClassLoader().getResource(NOMBRE);
        try {
            if (direccion != null) {
                this.prop.load(direccion.openStream());
            }
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LAF getLookAndFeel() {
        String property = prop.getProperty(KEY_LAF);
        return LAF.LAF_JTATOO;
    }

}
