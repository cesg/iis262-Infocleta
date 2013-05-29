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

    public Alumno(String nombre, String matricula, String apellidoMaterno) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.apellidoMaterno = apellidoMaterno;
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
}
