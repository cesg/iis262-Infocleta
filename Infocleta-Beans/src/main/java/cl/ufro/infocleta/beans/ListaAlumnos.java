package cl.ufro.infocleta.beans;

/**
 * Lista de alumnos.
 * 
 * @author c3sg
 * 
 */
public interface ListaAlumnos extends Iterable<Alumno> {
    /**
     * <p>
     * Inserta un alumno a la lista.
     * </p>
     * void insertar(Alumno a)
     * 
     * @param a
     */
    void insertar(Alumno a);

    /**
     * <p>
     * Elimina un alumno de la lista
     * </p>
     * boolean eliminar(Alumno a)
     * 
     * @param a
     * @return
     */
    boolean eliminar(Alumno a);

    /**
     * <p>
     * Obtiene un alumno de la lista.
     * </p>
     * Alumno obtener(String matricula)
     * 
     * @param matricula
     * @return
     */
    Alumno obtener(String matricula);

    /**
     * <p>
     * Verifica la existencia de un alumno en la lista.
     * </p>
     * boolean contiene(Alumno a)
     * 
     * @param a
     * @return
     */
    boolean contiene(Alumno a);

    /**
     * <p>
     * Obtiene el último alumno ingresado.
     * </p>
     * Alumno ultimo()
     * 
     * @return Último alumno.
     */
    Alumno ultimo();

    /**
     * <p>
     * Obtiene el primer alumno ingresado.
     * </p>
     * Alumno primero()
     * 
     * @return primer Alumno
     */
    Alumno primero();

    /**
     * <p>
     * Verifica si la lista esta vacia.
     * </p>
     * boolean estaVacia()
     * 
     * @return
     */
    boolean estaVacia();

    /**
     * <p>
     * Obtiene el número de alumnos ingresados.
     * </p>
     * int largo()
     * 
     * @return número de alumnos.
     */
    int largo();

//    /**
//     * <p>
//     * Ordena los alumnos segun su nombre.
//     * </p>
//     * void ordenarPorNombre()
//     */
//    void ordenarPorNombre();
//
//    /**
//     * <p>
//     * Ordena los alumno segun su Apellido materno.
//     * </p>
//     * void ordenarPorApellidoMaterno()
//     */
//    void ordenarPorApellidoMaterno();
//
//    /**
//     * <p>
//     * Ordena los alumno segun su Apellido paterno.
//     * </p>
//     * void ordenarPorApellidoPaterno()
//     */
//    void ordenarPorApellidoPaterno();
}
