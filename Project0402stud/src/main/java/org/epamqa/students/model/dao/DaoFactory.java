package org.epamqa.students.model.dao;

import org.epamqa.students.model.dao.mysqldao.MySqlDaoFactory;

/**
 * Created by Администратор on 04.02.2016.
 */
public abstract class DaoFactory {

    public abstract PersonDAO getPersonDAO();

    public static DaoFactory getFactory(DAOType type) {
        return type.getFactory();
    }

    /**
     * Enum to hold different factory types and implementations
     *
     */
    public enum DAOType {
        MYSQL (new MySqlDaoFactory());

        private DaoFactory factory;

        private DAOType(DaoFactory factory) {
            this.factory = factory;
        }

        public DaoFactory getFactory() {
            return factory;
        }
    }
}