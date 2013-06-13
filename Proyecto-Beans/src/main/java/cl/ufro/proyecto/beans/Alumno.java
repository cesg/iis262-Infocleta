package cl.ufro.proyecto.beans;

/**
 *
 * @author kristian
 */
public class Alumno {
    private String nombre;
    private String matricula;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Alumno(String nombre, String matricula, String apellidoMaterno,String apellidoPaterno) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
    
    
}