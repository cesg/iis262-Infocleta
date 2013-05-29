package cl.ufro.proyecto.beans;

import static cl.ufro.proyecto.beans.util.Utilidades.esNulo;

/**
 * <p>
 * Implementación de ListaAlumnos.
 * </p>
 * 
 * @author kristian
 * @see cl.ufro.proyecto.beans.ListaAlumnos
 */
public class ListaAlumnosImp implements ListaAlumnos {
    private Alumno[] alumnos;
    private int items;

    public ListaAlumnosImp(int largo) {
        this.alumnos = new Alumno[largo];
        items = 0;
    }

    public void insertar(Alumno a) {
        // FIXME: si los alumnos estubieran oredenado se pueden utilizar
        // busquedas avanzadas.
        if (esNulo(a) || items >= alumnos.length)
            return;

        this.alumnos[items] = a;
        items++;
    }

    public boolean eliminar(Alumno a) {
        if (esNulo(a))
            return false;
        for (int itr = 0; itr < items; itr++) {
            if (a.equals(alumnos[itr])) {
                // TODO: eliminar,ajustar
            }
        }
        return false;
    }

    public Alumno obtener(String matricula) {
        // FIXME: una busqueda binaria seria mejor, pero seria necesario que
        // este ordenado.
        for (Alumno item : alumnos) {
            if (matricula.equals(item.getMatricula())) {
                return item;
            }
        }
        return null;
    }

    public boolean contiene(Alumno a) {
        if (esNulo(a))
            return false;

        for (Alumno item : alumnos) {
            if (a.equals(item))
                return true;
        }
        return false;
    }

    public Alumno ultimo() {
        // TODO Auto-generated method stub
        return null;
    }

    public Alumno primero() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean estaVacia() {
        return items == 0;
    }

    public int largo() {
        return items;
    }

    public void ordenarPorNombre() {
        // TODO Auto-generated method stub

    }

    public void ordenarPorApellidoMaterno() {
        // TODO Auto-generated method stub

    }

    public void ordenarPorApellidoPaterno() {
        // TODO Auto-generated method stub
    }
}
