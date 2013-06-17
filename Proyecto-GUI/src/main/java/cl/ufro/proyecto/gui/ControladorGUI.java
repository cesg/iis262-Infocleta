/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.proyecto.gui;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

/**
 * Es la comunicación con la GUI Se debe ir agregabdo cada método necesario en
 * la GUI
 *
 * @author cesg
 */
public interface ControladorGUI {

    void agregarAlumno(Alumno a);

    Alumno buscarAlumno(Alumno a);
    
    boolean borrarAlumno(Alumno a);

    ListaAlumnos todosAlumnos();
}
