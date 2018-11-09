package database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import config.Config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
// TODO: Auto-generated Javadoc

/**
 * The Class Database.
 * @author
 */
/*
De klas database zorgt dat de app is gekopeld met dbms, waar de data wordt opgeslagen.
 */
public class Database {

    /** The instance. */
    private static Database instance;

    /** The Constant JDBC_DRIVER. */
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    /** The Constant JDBC_CONN_URL. */
    private static final String JDBC_CONN_URL = "jdbc:postgresql://"
            + Config.get("database", "server.hostname") + "/"
            + Config.get("database", "server.database");

    /** The Constant JDBC_USER. */
    private static final String JDBC_USER = Config.get("database", "server.username");
    
    /** The Constant JDBC_PASS. */
    private static final String JDBC_PASS = Config.get("database", "server.password");

    /** The combo pooled data source. */
    private ComboPooledDataSource comboPooledDataSource;

    /**
     * Gets the single instance of Database.
     *
     * @return single instance of Database
     */
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    /**
     * Instantiates a new database.
     */
    private Database() {
        try {
            this.comboPooledDataSource = new ComboPooledDataSource();
            this.comboPooledDataSource.setDriverClass(JDBC_DRIVER);
            this.comboPooledDataSource.setJdbcUrl(JDBC_CONN_URL);
            this.comboPooledDataSource.setUser(JDBC_USER);
            this.comboPooledDataSource.setPassword(JDBC_PASS);

        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = this.comboPooledDataSource.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

}
