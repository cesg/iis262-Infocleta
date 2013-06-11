package cl.ufro.proyecto.beans;

/**
 * <p>
 * Implementación de ListaAlumnos.
 * </p>
 * 
 * @author kristian
 * @see cl.ufro.proyecto.beans.ListaAlumnos
 */
public class ListaAlumnosArray implements ListaAlumnos {
    private Alumno[] alumnos;
    private int items;

    public ListaAlumnosArray(int largo) {
        this.alumnos = new Alumno[largo];
        items = 0;
    }

    public void insertar(Alumno a) {
        if (a == null || items >= alumnos.length)
            return;

        this.alumnos[items] = a;
        items++;
    }

    public boolean eliminar(Alumno a) {
        if (a == null)
            return false;
        for (int itr = 0; itr < items; itr++) {
            if (a.equals(alumnos[itr])) {
                // TODO: eliminar,ajustar
            }
        }
        return false;
    }

    public Alumno obtener(String matricula) {
        for (Alumno item : alumnos) {
            if (matricula.equals(item.getMatricula())) {
                return item;
            }
        }
        return null;
    }

    public boolean contiene(Alumno a) {
        if (a == null)
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
