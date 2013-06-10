/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.gui.ControladorGUI;
import cl.ufro.proyecto.gui.frames.Principal;

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
        Principal.iniciaNueva(controladorGUI);
    } 
}
