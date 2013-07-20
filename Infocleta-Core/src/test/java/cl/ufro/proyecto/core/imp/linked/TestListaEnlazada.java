package cl.ufro.proyecto.core.imp.linked;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;
import cl.ufro.infocleta.core.imp.linked.ListaEnlazada;

public class TestListaEnlazada {
    ListaAlumnos listaAlumnos;

    @Test
    public void testInsertar() {
	System.out.println("testInsertar()");
	ListaEnlazada listaAlumnos = new ListaEnlazada();
	Alumno a = new Alumno("Dummy", "1");
	Alumno a2 = new Alumno("Dummy2", "0");
	Alumno a3 = new Alumno("Dummy3", "2");
	Alumno a4 = new Alumno("Dummy2", "6");
	listaAlumnos.insertar(a);
	listaAlumnos.insertar(a2);
	listaAlumnos.insertar(a3);
	listaAlumnos.insertar(a4);
	assertFalse(listaAlumnos.estaVacia());
	for (Alumno alumno : listaAlumnos) {
	    System.out.print(alumno);
	    System.out.print(" ");
	}
	System.out.println();
	listaAlumnos.imprimeDesdeUlt();
    }

    @Test
    public void testEliminar() {
	System.out.println("testEliminar()");
	ListaEnlazada listaAlumnos = new ListaEnlazada();
	Alumno a = new Alumno("Dummy", "1");
	Alumno a2 = new Alumno("Dummy2", "0");
	// Alumno a3 = new Alumno("Dummy3", "2");
	// Alumno a4 = new Alumno("Dummy2", "6");
	listaAlumnos.insertar(a);
	listaAlumnos.insertar(a2);
	// listaAlumnos.insertar(a3);
	// listaAlumnos.insertar(a4);

	for (Alumno alumno : listaAlumnos) {
	    System.out.print(alumno);
	    System.out.print(" ");
	}
	System.out.println();

	boolean result = listaAlumnos.eliminar(a);
	listaAlumnos.eliminar(a2);
	assertTrue(result);
	for (Alumno alumno : listaAlumnos) {
	    System.out.print(alumno);
	    System.out.print(" ");
	}
	System.out.println();
	listaAlumnos.imprimeDesdeUlt();
    }

    @Test
    public void testContiene() {
	System.out.println("testContiene()");
	ListaEnlazada listaAlumnos = new ListaEnlazada();
	Alumno a = new Alumno("Dummy", "1");
	Alumno a2 = new Alumno("Dummy2", "0");
	Alumno a3 = new Alumno("Dummy3", "2");
	Alumno a4 = new Alumno("Dummy4", "6");
	Alumno a5 = new Alumno("Dummy6", "3");
	listaAlumnos.insertar(a);
	listaAlumnos.insertar(a2);
	listaAlumnos.insertar(a3);
	listaAlumnos.insertar(a4);
	listaAlumnos.insertar(a5);

	boolean result = listaAlumnos.contiene(a2);
	boolean result2 = listaAlumnos.contiene(a5);
	boolean result3 = listaAlumnos.contiene(a4);
	assertTrue(result);
	assertTrue(result2);
	assertTrue(result3);
    }

    @Test
    public void testObtener() {
	System.out.println("testObtener()");
	ListaEnlazada listaAlumnos = new ListaEnlazada();
	Alumno a = new Alumno("Dummy", "1");
	Alumno a2 = new Alumno("Dummy2", "0");
	Alumno a3 = new Alumno("Dummy3", "2");
	Alumno a4 = new Alumno("Dummy4", "6");
	Alumno a5 = new Alumno("Dummy6", "3");
	listaAlumnos.insertar(a);
	listaAlumnos.insertar(a2);
	listaAlumnos.insertar(a3);
	listaAlumnos.insertar(a4);
	listaAlumnos.insertar(a5);

	Alumno result = listaAlumnos.obtener("0");
	Alumno result2 = listaAlumnos.obtener("1");
	Alumno result3 = listaAlumnos.obtener("3");
	assertNotNull(result);
	assertNotNull(result2);
	assertNotNull(result3);
	assertEquals(a2, result);
	assertEquals(a, result2);
	assertEquals(a5, result3);
    }
}
