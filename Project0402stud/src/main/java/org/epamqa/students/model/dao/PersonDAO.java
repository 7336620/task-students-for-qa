package org.epamqa.students.model.dao;

import org.epamqa.students.model.connection.ConnectionManager;
import org.epamqa.students.model.entity.Person;

import java.util.List;

/**
 * Created by Администратор on 04.02.2016.
 */
public abstract class PersonDAO extends AbstractDAO{

    public PersonDAO(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    public abstract Person getPerson(int id);

    public abstract boolean createPerson(Person person);

    public abstract Person deletePerson(int id);

    public abstract List<Person> getListPersons();

    public abstract boolean swapPersons(int id,int id2);
}
