package cl.ufro.proyecto.core;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;
import cl.ufro.proyecto.beans.ListaAlumnosArray;
import cl.ufro.proyecto.gui.ControladorGUI;

/**
 *
 * @author kristian
 */
public class SimpleControladorGUI implements ControladorGUI{
    private ListaAlumnos lista;
    
    public SimpleControladorGUI(int largo){
	
	lista = new ListaAlumnosArray(largo);
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
