package service;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class Util {
	
	public static final String DB_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/testproject_db";
	public static final String DB_USER = "postgres";
	public static final String DB_PASS = "pswrd";

	public DataSource getDataSource() {
		PoolProperties props = new PoolProperties();
		props.setUrl(DB_URL);
		props.setDriverClassName(DB_DRIVER);
		props.setUsername(DB_USER);
		props.setPassword(DB_PASS);
		
		DataSource ds = new DataSource();
		ds.setPoolProperties(props);
		
		return ds;
	}
	
}
