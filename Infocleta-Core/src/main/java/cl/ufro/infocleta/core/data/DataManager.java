package cl.ufro.infocleta.core.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cl.ufro.infocleta.beans.Alumno;
import cl.ufro.infocleta.core.data.mapper.AlumnoMapper;

public class DataManager {
    private SqlSession session;
    private AlumnoMapper alumno;

    public DataManager() {
	session = ConnectionFactory.getSession().openSession();
	alumno = session.getMapper(AlumnoMapper.class);
    }

    public List<Alumno> obtenerTodos() {
	return alumno.getAll();
    }

    public void insertar(Alumno a) {
	alumno.insert(a);
    }

    public void borrar(Alumno a) {
	alumno.delete(a);
    }
}
