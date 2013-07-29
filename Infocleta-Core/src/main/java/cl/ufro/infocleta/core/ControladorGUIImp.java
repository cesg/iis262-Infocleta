package cl.ufro.infocleta.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.beans.ListaAlumnos;
import cl.ufro.infocleta.core.imp.linked.ListaEnlazada;
import cl.ufro.infocleta.core.persistencia.DataManager;
import cl.ufro.infocleta.gui.ControladorGUI;

/**
 * <p>
 * Controlador de la GUI de la aplicación
 * </p>
 * 
 * @author c3sg
 */
public class ControladorGUIImp implements ControladorGUI {
    private static final Logger LOG = LoggerFactory
	    .getLogger(ControladorGUIImp.class);
    private ListaAlumnos lista;
    private Queue<Alumno> cola;
    private DataManager db;

    public ControladorGUIImp() {
	db = new DataManager();
	lista = new ListaEnlazada();
	cola = new LinkedList<>();
	alumnosDB();
    }

    private void alumnosDB() {
	List<Alumno> alumnosDB = db.obtenerTodos();
	if (!alumnosDB.isEmpty())
	    for (Alumno alumno : alumnosDB) {
		lista.insertar(alumno);
	    }
    }

    @Override
    public void agregarAlumno(Alumno a) {
	ToStringBuilder sb = new ToStringBuilder(a,
	        ToStringStyle.SHORT_PREFIX_STYLE);
	sb.append("Matricula", a.getMatricula());
	sb.append("Nombre", a.getNombre());
	LOG.debug("Insertado {}", sb);
	if(!lista.contiene(a))
	    lista.insertar(a);
    }

    @Override
    public Alumno buscarAlumno(Alumno a) {
	ToStringBuilder sb = new ToStringBuilder(a,
	        ToStringStyle.SHORT_PREFIX_STYLE);
	sb.append("Matricula", a.getMatricula());
	sb.append("Nombre", a.getNombre());
	LOG.debug("# Buscando {}", sb);
	return lista.obtener(a.getMatricula());
    }

    @Override
    public ListaAlumnos todosAlumnos() {
	return lista;
    }

    @Override
    public boolean borrarAlumno(Alumno a) {
	ToStringBuilder sb = new ToStringBuilder(a,
	        ToStringStyle.SHORT_PREFIX_STYLE);
	sb.append("Matricula", a.getMatricula());
	sb.append("Nombre", a.getNombre());
	LOG.debug("Eliminando {}", sb);
	db.borrar(a);
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
	LOG.debug("Alumno agregado a la cola: {}", a);
    }

    @Override
    public Queue<Alumno> obtenerAlumnosEnCola() {
	return cola;
    }

    @Override
    public void vaciarCola() {
	LOG.debug("Vaciando cola, elementos {}", cola.size());
	for (Alumno alumno : cola) {
	    boolean exists = borrarAlumno(alumno);
	    if (exists) {
		LOG.debug("Alumno eliminado de la lista  id: {}", alumno);
		cola.remove(alumno);
	    } else
		LOG.debug("No se encontro al alumno en la lista id: {}", alumno);

	}
	cola.clear();
    }

    @Override
    public int alumnosEnCola() {
	return cola.size();
    }

    public void obtenerDB() {
	List<Alumno> l = db.obtenerTodos();
	for (Alumno alumno : l) {
	    lista.insertar(alumno);
	}
    }

    @Override
    public void cerrarAplicacion() {
	LOG.debug("# Guardando lista..");
	if (!lista.estaVacia()) {
	    List<Alumno> alumnosDB = db.obtenerTodos();
	    for (Alumno alumno : lista) {
		if (!alumnosDB.contains(alumno))
		    db.insertar(alumno);
	    }
	}
	db.cerrarSession();
//	System.exit(0);
    }
}
