package cl.ufro.infocleta.core.data;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;

public class ConnectionFactory {
    private static final String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlMapper;
    private static Reader reader;
    private static final Logger log = org.slf4j.LoggerFactory
	    .getLogger(ConnectionFactory.class);

    static {
	try {
	    reader = Resources.getResourceAsReader(resource);
	    sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	} catch (final Exception e) {
	    log.error("## ", e);
	}
    }

    /**
     * Obtiene una session para comunicarse con <br/>
     * una base de datos.
     * 
     * @return una instancia de una session.
     */
    public static SqlSessionFactory getSession() {
	return sqlMapper;
    }
}
