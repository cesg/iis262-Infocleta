package cl.ufro.infocleta.core.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.core.persistencia.mapper.AlumnoMapper;

public class DataManager {
    private SqlSession session;
    private AlumnoMapper alumnoMapper;
    private static final Logger LOG = LoggerFactory
	    .getLogger(DataManager.class);

    public DataManager() {
	final SqlSessionFactory sessionFactory = ConnectionFactory.getSession();
	if (sessionFactory != null) {
	    session = sessionFactory.openSession();
	    alumnoMapper = session.getMapper(AlumnoMapper.class);
	}
    }

    public List<Alumno> obtenerTodos() {
	List<Alumno> lista = new ArrayList<>();
	lista = alumnoMapper.getAll();
	return lista;
    }

    public void insertar(Alumno a) {
	if (alumnoMapper.insert(a) > 0)
	    session.commit();
    }

    public void borrar(Alumno a) {
	if (alumnoMapper.delete(a) > 0)
	    session.commit();
    }

    public void cerrarSession() {
	this.session.close();
    }
}
