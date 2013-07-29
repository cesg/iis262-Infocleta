package cl.ufro.infocleta.core.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cl.ufro.infocleta.beans.Alumno;

public interface AlumnoMapper {
    String SELECT_ALL = "SELECT * FROM alumno";
    String INSERT = "INSERT INTO alumno (matricula,nombre) values (#{matricula},#{nombre})";
    String DELETE = "DELETE FROM alumno where matricula=#{matricula}";

    @Select(SELECT_ALL)
    List<Alumno> getAll();

    @Insert(INSERT)
    int insert(Alumno a);

    @Delete(DELETE)
    int delete(Alumno a);
}
