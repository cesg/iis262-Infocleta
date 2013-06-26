package cl.ufro.infocleta.core;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;
import cl.ufro.infocleta.core.imp.linked.ListaEnlazada;
import cl.ufro.infocleta.gui.ControladorGUI;

/**
 * <p>
 * Controlador de la GUI de la aplicación
 * </p>
 * 
 * @author c3sg
 */
public class ControladorGUIImp implements ControladorGUI {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(ControladorGUIImp.class);
	private ListaAlumnos lista;
	private Queue<Alumno> cola;

	public ControladorGUIImp() {

		lista = new ListaEnlazada();
		cola = new LinkedList<>();
	}

	@Override
	public void agregarAlumno(Alumno a) {
		LOGGER.debug("Insertando Alumno {}: ", a);
		lista.insertar(a);
	}

	@Override
	public Alumno buscarAlumno(Alumno a) {
		LOGGER.debug("# Buscando Alumno {}", a);
		return lista.obtener(a.getMatricula());
	}

	@Override
	public ListaAlumnos todosAlumnos() {
		return lista;
	}

	@Override
	public boolean borrarAlumno(Alumno a) {
		LOGGER.debug("Eliminando Alumno {}", a);
		return lista.eliminar(a);
	}

	@Override
	public Alumno buscarAlumno(String codigo) {
		return lista.obtener(codigo);
	}

	@Override
	public boolean borrarAlumno(String codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarACola(Alumno a) {
		cola.add(a);
	}

	@Override
	public Queue<Alumno> obtenerAlumnosEnCola() {
		return cola;
	}

}
