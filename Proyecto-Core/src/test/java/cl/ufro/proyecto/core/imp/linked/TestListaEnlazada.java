package cl.ufro.proyecto.core.imp.linked;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

public class TestListaEnlazada {
    ListaAlumnos listaAlumnos;
    @Test
    public void testInsertar() {
	listaAlumnos = new ListaEnlazada();
	Alumno a = new Alumno("Dummy", "12345678", null, null);
	Alumno a2 = new Alumno("Dummy2", "10345678", null, null);
	listaAlumnos.insertar(a);
	listaAlumnos.insertar(a2);
	for (Alumno alumno : listaAlumnos) {
	    System.out.print(alumno);
	    System.out.print(" - ");
	}
    }

}
