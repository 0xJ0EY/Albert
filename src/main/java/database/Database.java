package database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import config.Config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static Database instance;

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_CONN_URL = "jdbc:postgresql://"
            + Config.get("database", "server.hostname") + "/"
            + Config.get("database", "server.database");

    private static final String JDBC_USER = Config.get("database", "server.username");
    private static final String JDBC_PASS = Config.get("database", "server.password");

    private ComboPooledDataSource comboPooledDataSource;

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

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
