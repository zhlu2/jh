package aco.connection;



import javax.sql.DataSource;

import org.apache.commons.dbcp.*;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by ZhangXin on 2017-01-20.
 */
public class LogConnectionFactory {

    private static String driver;
    private static String url;
    private static String user;
    private static String password ;

    private static interface Singleton {
        final LogConnectionFactory INSTANCE = new LogConnectionFactory();
    }

    private final DataSource dataSource;

    private LogConnectionFactory() {
        loadProperties();
        initDriver();

        GenericObjectPool pool = new GenericObjectPool();
        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, user, password);
        new PoolableConnectionFactory(
                connectionFactory, pool, null, "select 1 from dual", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );
        this.dataSource = new PoolingDataSource(pool);
    }

    private static void loadProperties() {
        try {
            InputStream stream = LogConnectionFactory.class.getClassLoader().getResourceAsStream("config.properties");
            Properties props = new Properties();
            props.load(stream);
            stream.close();
            driver = props.getProperty("driverClassName");
            url = props.getProperty("jdbc_url");
            user = props.getProperty("jdbc_username");
            password = props.getProperty("jdbc_password");
            System.out.println(driver+ url+ user+ password);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private static void initDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
