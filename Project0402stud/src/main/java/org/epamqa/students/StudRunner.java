package org.epamqa.students;

import org.epamqa.students.model.dao.DaoFactory;
import org.epamqa.students.model.entity.Person;

/**
 * Created by Администратор on 04.02.2016.
 */
public class StudRunner {
    public static void main(String[] args)
    {
        System.out.println("test");
        DaoFactory FACTORY = DaoFactory.getFactory(DaoFactory.DAOType.MYSQL);
        Person person = FACTORY.getPersonDAO().getPerson(1);
        System.out.println(person);

    }


}
