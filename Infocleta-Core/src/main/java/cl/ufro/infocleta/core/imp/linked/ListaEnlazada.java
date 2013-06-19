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
        while (actual != null && a.compareTo(actual.getValue()) > 0) {
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
        Nodo<Alumno> actual = primero;
        // Nodo<Alumno> anterior = null;
        while (!a.equals(actual.getValue())) {
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
        return null;
    }

    @Override
    public boolean contiene(Alumno a) {
        return recContiene(a, primero, ultimo);
    }

    public boolean recContiene(Alumno a, Nodo<Alumno> izq, Nodo<Alumno> der) {
        if (izq.next == der) {
            
        } else {
            Nodo<Alumno> centro = center(izq, der);
            if (centro.equals(a))
                return true;
            else if (a.compareTo(centro.getValue()) < 0)
                recContiene(a, izq, centro);
            else
                recContiene(a, centro, der);
        }
        return false;
    }

    @Override
    public Alumno ultimo() {
        return ultimo.getValue();
    }

    @Override
    public Alumno primero() {
        return primero.getValue();
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
            System.out.print(actual.getValue());
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
            return actual.getValue();
        }

        @Override
        public void remove() {
        }
    }
}
