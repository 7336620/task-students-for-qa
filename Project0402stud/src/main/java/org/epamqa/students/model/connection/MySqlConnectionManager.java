package org.epamqa.students.model.connection;

/**
 * Created by Администратор on 04.02.2016.
 */

import javax.naming.Context;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class MySqlConnectionManager extends ConnectionManager {

    private Context context;
    private DataSource datasource;
    private static MySqlConnectionManager instance;

    private String dbUrl ;
    private String dbUser ;
    private String dbPass ;
    private String dbDriver ;
    /**
     * Static method to get single instance (singleton)
     *
     * @return instance of manager
     */
    public static MySqlConnectionManager getInstace() {
        if (instance == null) {
            instance = new MySqlConnectionManager();
        }

        return instance;
    }

    /**
     * Constructor
     */
    private MySqlConnectionManager() {

        try {
            Properties dbProperties = new Properties();

            try {
                dbProperties.load(MySqlConnectionManager.class.getResourceAsStream("/db.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Database properties loaded");

            dbUrl = dbProperties.getProperty("db.url");
            dbUser = dbProperties.getProperty("db.user");
            dbPass = dbProperties.getProperty("db.pass");
            dbDriver = dbProperties.getProperty("db.driver");

            Class.forName(dbDriver);
        } catch (Exception e) {
			e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser,dbPass);
        } catch (Exception e) {
			e.printStackTrace();
        }

        return connection;
    }

}
