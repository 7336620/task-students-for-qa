package org.epamqa.students.model.dao.mysqldao;

import org.epamqa.students.model.dao.AbstractDAO;
import org.epamqa.students.model.dao.DaoFactory;
import org.epamqa.students.model.dao.PersonDAO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 04.02.2016.
 */
public class MySqlDaoFactory extends DaoFactory {

    private Map<String, AbstractDAO> daos = new HashMap<>();

    public MySqlDaoFactory() {
        daos.put("person", new MySqlPersonDAO());
//        daos.put("foo", new MySqlEmptyDAO());
//        daos.put("bar", new MySqlEmptyDAO());
    }

    @Override
    public PersonDAO getPersonDAO() {
        return (PersonDAO) daos.get("person");
    }


}
