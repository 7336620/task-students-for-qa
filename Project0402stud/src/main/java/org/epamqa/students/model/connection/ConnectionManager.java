package org.epamqa.students.model.connection;

/**
 * Created by Администратор on 04.02.2016.
 */
import java.sql.Connection;

public abstract class ConnectionManager {

    public abstract Connection getConnection();
}
