package cl.ufro.proyecto.core.imp.linked;

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
        if (estaVacia()) {
            primero = nuevo;
        }
        while (actual != null) {
            if (a.compareTo(actual.getValue()) < 0) {
                actual.prev.next = nuevo;
                nuevo.next = actual;
                nuevo.prev = actual.prev;
                actual.prev = nuevo;
            }
                actual = actual.next;
        }
       
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

    private void swap(Nodo<Alumno> a, Nodo<Alumno> b) {
        if (a == b)
            return;

        if (isEnds(a) && isEnds(b))
            swapEnds(a, b);
        else if (a.next == b || b.next == a)
            swapNear(a, b);
        else if (a.prev == null)
            swapFirst(a, b);
        else {
            Nodo<Alumno> tempBNext = b.next;
            Nodo<Alumno> tempBPrev = b.prev;
            Nodo<Alumno> tempANext = a.next;
            Nodo<Alumno> tempAPrev = a.prev;
            a.prev.next = b;
            a.next = tempBNext;
            b.next = tempANext;
            a.prev = b.prev;
            if (tempANext != null)
                tempANext.prev = b;
            b.prev = tempAPrev;
            tempBPrev.next = a;
            if (tempBNext != null)
                tempBNext.prev = a;
        }

        if (a.equals(primero)) {
            primero = b;
        } else if (b.equals(primero)) {
            primero = a;
        }
    }

    private void swapNear(Nodo<Alumno> a, Nodo<Alumno> b) {
        Nodo<Alumno> tempA = a;
        Nodo<Alumno> tempB = b;
        Nodo<Alumno> tempBPrev = b.prev;
        if (b.next == a) {// a esta despues de b
            if (tempB.prev != null) // first
                tempB.prev.next = a;
            if (tempA.next != null) // last
                tempA.next.prev = b;
            b.prev = a;
            b.next = a.next;
            a.next = b;
            a.prev = tempBPrev;
        } else if (a.next == b) {// b esta despues de a
            if (tempB.next == null) {
                swapNearNextNull(a, b);
            } else {
                if (tempA.prev != null) // fisrt
                    tempA.prev.next = b;

                if (tempA.next != null) // last
                    tempB.next.prev = a;

                b.prev = tempA.prev;
                a.prev = b;
                a.next = tempB.next;
                b.next = a;
            }
        }
    }

    private void swapNearNextNull(Nodo<Alumno> a, Nodo<Alumno> b) {
        Nodo<Alumno> tempAPrev = a.prev;
        a.prev.next = b;
        a.next = b.next;
        a.prev = b;
        b.next = a;
        b.prev = tempAPrev;
    }

    private void swapEnds(Nodo<Alumno> a, Nodo<Alumno> b) {

        if (a.prev == null) {
            // a first & b last
            Nodo<Alumno> tempANext = a.next;
            Nodo<Alumno> tempBPrev = b.prev;
            a.next = b.next;
            b.prev.next = a;
            b.next = tempANext;
            b.prev = a.prev;
            b.next.prev = b;
            a.prev = tempBPrev;
        } else if (b.prev == null) {
            // b first & a last
            Nodo<Alumno> tempBNext = b.next;
            Nodo<Alumno> tempAPrev = a.prev;
            b.next = a.next;
            a.prev.next = b;
            a.next = tempBNext;
            a.prev = b.prev;
            a.next.prev = a;
            b.prev = tempAPrev;
        }
    }

    private void swapFirst(Nodo<Alumno> a, Nodo<Alumno> b) {
        if (a.prev == null) {
            Nodo<Alumno> tempANext = a.next;
            Nodo<Alumno> tempBprev = b.prev;
            a.next = b.next;
            b.prev.next = a;
            b.next = tempANext;
            b.next.prev = b;
            b.prev = a.prev;
            a.next.prev = a;
            a.prev = tempBprev;
        } else if (b.prev == null) {
            // TODO: si b es el primero.
        }
    }

    private boolean isEnds(Nodo<Alumno> a) {
        return (a.prev == null || a.next == null);
    }
}
