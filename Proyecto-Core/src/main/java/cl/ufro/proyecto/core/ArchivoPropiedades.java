/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import java.net.URL;

/**
 *
 * @author kristian
 */
public abstract class ArchivoPropiedades {

    protected final String KEY_LAF;
    protected final String KEY_;
    protected final String NOMBRE;
    protected final URL direccion;

    public ArchivoPropiedades() {
        this.KEY_LAF = "laf";
        this.KEY_ = "void";
        this.NOMBRE = "Proyecto.conf";
        direccion = getClass().getClassLoader().getResource(NOMBRE);
    }
    
    protected enum lafValoresSoportados {
        SYSTEM("sistema"),
        JTATTOO("jtatto");
        
        private String value;
        private lafValoresSoportados(String value){
            this.value = value;
        }
        
        public String getValue (){
        return value;
        }
    }
}
