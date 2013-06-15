package cl.ufro.proyecto.core.imp.linked;

import static org.junit.Assert.*;

import org.junit.Test;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

public class TestListaEnlazada {
    ListaAlumnos listaAlumnos;

    @Test
    public void testInsertar() {
        ListaEnlazada listaAlumnos = new ListaEnlazada();
        Alumno a = new Alumno("Dummy", "1");
        Alumno a2 = new Alumno("Dummy2", "0");
        Alumno a3 = new Alumno("Dummy3", "2");
        Alumno a4 = new Alumno("Dummy2", "6");
        listaAlumnos.insertar(a);
        listaAlumnos.insertar(a2);
        listaAlumnos.insertar(a3);
        listaAlumnos.insertar(a4);
        for (Alumno alumno : listaAlumnos) {
            System.out.print(alumno);
            System.out.print(" ");
        }
        System.out.println();
        listaAlumnos.imprimeDesdeUlt();
    }
}
