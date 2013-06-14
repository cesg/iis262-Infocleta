package cl.ufro.proyecto.core.imp.linked;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

/**
 * Lista enlazada de inserción ordenada.
 * @author c3sg
 *
 */
public class ListaEnlazada implements ListaAlumnos {
    private Nodo primero;
    private Nodo ultimo;
    private int items;
    public ListaEnlazada() {
       items = 0;
    }
    
    @Override
    public void insertar(Alumno a) {
        
    }

    @Override
    public boolean eliminar(Alumno a) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Alumno obtener(String matricula) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contiene(Alumno a) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Alumno ultimo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alumno primero() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean estaVacia() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int largo() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void ordenarPorNombre() {
        // TODO Auto-generated method stub

    }

    @Override
    public void ordenarPorApellidoMaterno() {
        // TODO Auto-generated method stub

    }

    @Override
    public void ordenarPorApellidoPaterno() {
        // TODO Auto-generated method stub

    }

}
