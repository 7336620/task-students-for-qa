package org.epamqa.students.controller;

import org.epamqa.students.model.entity.Person;
import org.epamqa.students.view.Printer;

import java.io.BufferedReader;
import java.util.List;

/**
 * Created by timvt on 05.02.2016.
 */
public class ActionList extends Action {
    @Override
    public String execute(Printer printer, BufferedReader reader) {
        List<Person> persons = FACTORY.getPersonDAO().getListPersons();
        for (Person person:persons){
            printer.printPersonBrief(person.getId(),person.getLastName());
        }
        return "";
    }
}
