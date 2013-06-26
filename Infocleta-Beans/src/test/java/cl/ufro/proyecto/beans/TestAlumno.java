package cl.ufro.proyecto.beans;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.ufro.infocleta.beans.Alumno;

public class TestAlumno {

    @Test
    public void testComparar() {
	Alumno a = new Alumno("Dummy", "123456-k");
	Alumno a2 = new Alumno("Dummy2", "123459-9");
	int result = a.compareTo(a2);
	assertTrue(result < 1);
    }

}
