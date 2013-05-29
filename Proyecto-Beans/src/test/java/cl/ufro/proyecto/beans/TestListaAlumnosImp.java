package cl.ufro.proyecto.beans;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestListaAlumnosImp {

    private ListaAlumnos lista;
    int largo = 10;
    
    @Test
    public void testListaAlumnosImp() {
	lista = new ListaAlumnosImp(largo);
    }

    @Test
    public void testInsertar() {
	Alumno a = new Alumno("Juan", "1234567813", "Peres","Foo");
	lista = new ListaAlumnosImp(largo);
	lista.insertar(a);
	assertFalse(lista.estaVacia());
    }

    @Test
    public void testEliminar() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testObtener() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testContiene() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testUltimo() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testPrimero() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testEstaVacia() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testLargo() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testOrdenarPorNombre() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testOrdenarPorApellidoMaterno() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testOrdenarPorApellidoPaterno() {
	fail("Not yet implemented"); // TODO
    }

}
