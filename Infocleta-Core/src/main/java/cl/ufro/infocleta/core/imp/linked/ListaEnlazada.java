package cl.ufro.infocleta.core.imp.linked;

import java.util.Iterator;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;

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
	primero = null;
	ultimo = null;
	items = 0;
    }

    @Override
    public void insertar(Alumno a) {
	if (a == null)
	    throw new IllegalArgumentException("El atributo no puede ser nulo.");

	Nodo<Alumno> nuevo = new Nodo<>(a);
	Nodo<Alumno> actual = primero;
	Nodo<Alumno> anterior = null;
	// Mientras 'a' sea mayor que el Alumno en actual.
	while (actual != null && a.compareTo(actual.value) > 0) {
	    anterior = actual;
	    actual = actual.next;
	}
	if (anterior == null) {
	    primero = nuevo;
	} else {
	    anterior.next = nuevo;
	    nuevo.prev = anterior;
	}
	nuevo.next = actual;
	if (actual != null)
	    actual.prev = nuevo;

	if (nuevo.next == null)
	    ultimo = nuevo;
	items++;
    }

    @Override
    public boolean eliminar(Alumno a) {
	if (estaVacia() || a == null)
	    return false;
	// FIXME Utilizar metodo obtener para mejor desempeño.
	Nodo<Alumno> actual = primero;
	// Nodo<Alumno> anterior = null;
	while (!a.equals(actual.value)) {
	    actual = actual.next;
	    if (actual == null)
		return false;
	}
	if (actual == primero)
	    primero = actual.next;
	else
	    actual.prev.next = actual.next;
	items--;
	return true;
    }

    @Override
    public Alumno obtener(String matricula) {
	Alumno a = new Alumno(null, matricula);
	return recObtener(a, primero, ultimo);
    }

    /**
     * <p>
     * Obtiene una alumno de forma recursiva imitando el métido de busqueda
     * binaria.
     * </p>
     * 
     * @param a
     * @param izq
     * @param der
     * @return
     */
    public Alumno recObtener(Alumno a, Nodo<Alumno> izq, Nodo<Alumno> der) {
	Alumno alumno = null;
	if (a.equals(izq.value)) {
	    alumno = izq.value;
	} else if (a.equals(der.value))
	    alumno = der.value;
	else if (izq.next == der) {
	    if (a.equals(izq.value))
		alumno = izq.value;
	    else if (a.equals(der.value))
		alumno = der.value;
	} else {
	    Nodo<Alumno> centro = center(izq, der);
	    if (centro.value.equals(a))
		alumno = centro.value;
	    else if (a.compareTo(centro.value) < 0)
		alumno = recObtener(a, izq, centro);
	    else if (a.compareTo(centro.value) > 0)
		alumno = recObtener(a, centro, der);
	}
	return alumno;
    }

    @Override
    public boolean contiene(Alumno a) {
	return recContiene(a, primero, ultimo);
    }

    /**
     * Busqueda binaria recursiva.
     * 
     * @param a
     *            Alumno a buscar.
     * @param izq
     *            limite izquierdo
     * @param der
     *            limite derecho
     * @return
     */
    public boolean recContiene(Alumno a, Nodo<Alumno> izq, Nodo<Alumno> der) {
	boolean contiene = false;
	if (a.equals(izq.value) || a.equals(der.value)) {
	    contiene = true;
	} else if (izq.next == der) {
	    if (a.equals(izq.value) || a.equals(der.value))
		contiene = true;
	} else {
	    Nodo<Alumno> centro = center(izq, der);
	    if (centro.value.equals(a))
		contiene = true;
	    else if (a.compareTo(centro.value) < 0)
		contiene = recContiene(a, izq, centro);
	    else if (a.compareTo(centro.value) > 0)
		contiene = recContiene(a, centro, der);
	}
	return contiene;
    }

    @Override
    public Alumno ultimo() {
	return ultimo.value;
    }

    @Override
    public Alumno primero() {
	return primero.value;
    }

    @Override
    public boolean estaVacia() {
	return items == 0;
    }

    @Override
    public int largo() {
	return items;
    }

    @Override
    public Iterator<Alumno> iterator() {
	return new ListaEnlazadaItr();
    }

    public void imprimeDesdeUlt() {
	Nodo<Alumno> actual = ultimo;
	System.out.print("{ ");
	while (actual != null) {
	    System.out.print(actual.value);
	    System.out.print(" ");
	    actual = actual.prev;
	}
	System.out.print("}");
    }

    /**
     * <p>
     * Verifica si un nodo esta delante de otro
     * </p>
     * boolean isForward(Nodo base, Nodo target)
     * 
     * @param base
     *            node to start search.
     * @param target
     *            node to find
     * @return
     */
    private boolean isForward(Nodo<Alumno> base, Nodo<Alumno> target) {
	if (base.getNext() == target)
	    return true;

	Nodo<Alumno> current = base;
	while (current != null) {
	    if (current == target)
		return true;
	    current = current.getNext();
	}
	return false;
    }

    /**
     * <p>
     * Verifica si un nodo esta detras de otro.
     * </p>
     * boolean isBackward(Nodo base, Nodo target)
     * 
     * @param base
     * @param target
     * @return
     */
    private boolean isBackward(Nodo<Alumno> base, Nodo<Alumno> target) {
	Nodo<Alumno> current = base;
	while (current != null) {
	    if (current == target)
		return true;
	    current = current.getPrev();
	}
	return false;
    }

    /**
     * <p>
     * Busca un nodo central entre dos nodos dados. De ser elementos par tomará
     * el de la izquierda.
     * </p>
     * Nodo center(Nodo a, Nodo b)
     * 
     * @param a
     * @param b
     * @return
     */
    private Nodo<Alumno> center(Nodo<Alumno> a, Nodo<Alumno> b) {
	Nodo<Alumno> tempA = a;
	Nodo<Alumno> tempB = b;
	if (isForward(a, b)) {
	    while (tempA != tempB) {
		tempB = tempB.getPrev();
		if (tempA == tempB)
		    break;
		tempA = tempA.getNext();
	    }
	} else if (isBackward(a, b)) {
	    while (tempA != tempB) {
		tempA = tempA.getPrev();
		if (tempA == tempB)
		    break;
		tempB = tempB.getNext();
	    }
	}
	return tempB;
    }

    /**
     * <p>
     * Implementación de un iterador para una lista enlazada de alumnos
     * </p>
     * 
     * @author c3sg
     * 
     */
    protected class ListaEnlazadaItr implements Iterator<Alumno> {

	private boolean first;
	Nodo<Alumno> actual;

	public ListaEnlazadaItr() {
	    first = true;
	    actual = primero;
	}

	@Override
	public boolean hasNext() {
	    if (first)
		return true;
	    else
		return actual.next != null;
	}

	@Override
	public Alumno next() {
	    if (!first)
		actual = actual.next;
	    first = false;
	    return actual.value;
	}

	@Override
	public void remove() {
	}
    }
}
