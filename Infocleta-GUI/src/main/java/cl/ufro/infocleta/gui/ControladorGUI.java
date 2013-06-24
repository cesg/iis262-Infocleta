package cl.ufro.infocleta.gui;

import java.util.Queue;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;

/**
 * Es la comunicación con la GUI Se debe ir agregabdo cada método necesario en
 * la GUI
 * 
 * @author cesg
 */
public interface ControladorGUI {

    /**
     * <p>
     * Agrega un alumno
     * </p>
     * agregarAlumno(Alumno a)
     * 
     * @param a
     */
    void agregarAlumno(Alumno a);

    /**
     * <p>
     * Busca un alumno.
     * </p>
     * buscarAlumno(Alumno a)
     * 
     * @param a
     * @return
     */
    Alumno buscarAlumno(Alumno a);

    /**
     * <p>
     * Busca un alumno según un atributo que lo hace unico.
     * </p>
     * buscarAlumno(String codigo)
     * 
     * @param codigo
     * @return
     */
    Alumno buscarAlumno(String codigo);

    /**
     * <p>
     * Elimina un alumno
     * </p>
     * borrarAlumno(Alumno a)
     * 
     * @param a
     * @return
     */
    boolean borrarAlumno(Alumno a);

    /**
     * <p>
     * Elimina un alumno según un atributo que lo hace unico.
     * </p>
     * borrarAlumno(String codigo)
     * 
     * @param codigo
     * @return
     */
    boolean borrarAlumno(String codigo);

    /**
     * <p>
     * Obtiene todos los alumnos en una <code>ListaAlumnos</code>
     * </p>
     * todosAlumnos()
     * 
     * @return
     */
    ListaAlumnos todosAlumnos();

    /**
     * <p>
     * Agrega un alumno a la cola, para luego poder eliminarlo de la lista
     * </p>
     * 
     * @param a
     */
    void agregarACola(Alumno a);
    
    Queue<Alumno> obtenerAlumnosEnCola();
}
