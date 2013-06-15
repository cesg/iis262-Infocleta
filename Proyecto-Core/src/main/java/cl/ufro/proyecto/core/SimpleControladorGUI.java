package cl.ufro.proyecto.core;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;
import cl.ufro.proyecto.core.imp.linked.ListaEnlazada;
import cl.ufro.proyecto.gui.ControladorGUI;

/**
 *
 * @author c3sg
 */
public class SimpleControladorGUI implements ControladorGUI{
    private ListaAlumnos lista;
    
    public SimpleControladorGUI(int largo){
	
	lista = new ListaEnlazada();
    }
    
    @Override
    public void agregarAlumno(Alumno a) {
        lista.insertar(a);
    }

    @Override
    public Alumno buscarAlumno(Alumno a) {
       lista.contiene(a);
        return null;
    }

    @Override
    public ListaAlumnos todosAlumnos() {
        return lista;
    }
    
}
