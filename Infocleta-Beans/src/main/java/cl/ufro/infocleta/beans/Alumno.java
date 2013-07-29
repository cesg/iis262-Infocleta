package cl.ufro.infocleta.beans;


/**
 * <p>
 * Representa un alumno. Implementa <code>java.lang.Comparable </code> para
 * comparar un alumno de otro según su matrícula.
 * </p>
 * 
 * @author infocleta
 */
public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private String matricula;

    public Alumno() {
    }

    /**
     * Nuevo alumno solo con su nombre y matricula.
     * 
     * @param nombre
     * @param matricula
     */
    public Alumno(String nombre, String matricula) {
	this.nombre = nombre;
	this.matricula = matricula;
    }

    public String getNombre() {
	return nombre;
    }

    public String getMatricula() {
	return matricula;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
	        + ((matricula == null) ? 0 : matricula.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Alumno other = (Alumno) obj;
	if (matricula == null) {
	    if (other.matricula != null) {
		return false;
	    }
	} else if (!matricula.equals(other.matricula)) {
	    return false;
	}
	return true;
    }

    public String toString() {
	return this.matricula;
    }

    public int compareTo(Alumno a) {
	return matricula.compareTo(a.getMatricula());
    }
}
