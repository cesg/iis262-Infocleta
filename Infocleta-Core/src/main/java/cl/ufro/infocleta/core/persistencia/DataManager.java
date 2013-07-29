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
	try {
	    lista = alumnoMapper.getAll();
	} catch (Exception e) {
	    LOG.error("", e);
	}

	return lista;
    }

    public void insertar(Alumno a) {
	int result = 0;
	try {
	    result = alumnoMapper.insert(a);
	} catch (Exception e) {
	    LOG.error("", e);
	}
	LOG.debug("{}", result);
	session.commit();
    }

    public void borrar(Alumno a) {
	int result = 0;
	try {
	    result = alumnoMapper.delete(a);
	} catch (Exception e) {
	    LOG.error("", e);
	}
	LOG.debug("{}",result);
	session.commit();
    }

    public void cerrarSession() {
	this.session.close();
    }
}
