package org.epamqa.students.model.dao;

/**
 * Created by Администратор on 04.02.2016.
 */

import org.epamqa.students.model.connection.ConnectionManager;

public abstract class AbstractDAO {


    protected ConnectionManager connectionManager;

    public AbstractDAO(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}