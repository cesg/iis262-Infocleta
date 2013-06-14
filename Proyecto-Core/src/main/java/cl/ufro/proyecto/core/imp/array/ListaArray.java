package cl.ufro.proyecto.core.imp.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.proyecto.beans.Alumno;
import cl.ufro.proyecto.beans.ListaAlumnos;

/**
 * @author c3sg
 * 
 */
public class ListaArray implements ListaAlumnos {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ListaArray.class);
    private int largo;
    private int items;
    private Alumno[] alumnos;

    public ListaArray(int largo) {
        this.largo = largo;
        this.items = 0;
        this.alumnos = new Alumno[largo];
    }

    @Override
    public void insertar(Alumno a) {
        if (largo == items)
            LOGGER.info("# La lsita esta completa.");
        else {
            this.alumnos[items++] = a;
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
}
