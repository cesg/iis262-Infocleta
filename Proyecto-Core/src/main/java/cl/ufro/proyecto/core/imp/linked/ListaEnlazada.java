package cl.ufro.proyecto.core.imp.linked;

import java.util.Iterator;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

/**
 * Lista enlazada de inserción ordenada.
 * 
 * @author c3sg
 * 
 */
public class ListaEnlazada implements ListaAlumnos {
    private Nodo<Alumno> primero;
    private Nodo<Alumno> ultimo;
    private int items;

    public ListaEnlazada() {
	items = 0;
    }

    @Override
    public void insertar(Alumno a) {
	Nodo<Alumno> nuevo = new Nodo<>(a);
	Nodo<Alumno> actual = primero;
	Nodo<Alumno> anterior = null;
	while (actual != null && a.compareTo(actual.getValue()) > 0) {
	    anterior = actual;
	    actual = actual.next;
	}
	if (anterior == null)
	    primero = nuevo;
	else {
	    anterior.next = nuevo;
	}
	// nuevo.prev = actual.prev;
	nuevo.next = actual;
	// actual.prev = nuevo;

	items++;
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
    public Iterator<Alumno> iterator() {
	return new ListaEnlazadaItr();
    }

    protected class ListaEnlazadaItr implements Iterator<Alumno> {

	private boolean first;
	Nodo<Alumno> actual;

	public ListaEnlazadaItr() {
	    first = true;
	    actual = primero;
	}

	@Override
	public boolean hasNext() {
	    return actual.next != null;
	}

	@Override
	public Alumno next() {
	    if (!first)
		actual = actual.next;
	    first = false;
	    return actual.getValue();
	}

	@Override
	public void remove() {
	}

    }
}
