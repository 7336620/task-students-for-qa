package org.epamqa.students.controller;

import org.epamqa.students.model.entity.Person;
import org.epamqa.students.view.Printer;

import java.io.BufferedReader;

/**
 * Created by timvt on 05.02.2016.
 */
public class ActionFullPerson extends Action {
    public String execute(Printer printer, BufferedReader reader) {
        Person person;
        printer.printInputNumber();
        try{
            String inputString = reader.readLine();
            int result = Integer.parseInt(inputString);
            person = FACTORY.getPersonDAO().getPerson(result);
        }catch (Exception e){
            printer.printInputError();
            return "";
        }
        if( person == null){
            printer.printInputError();
        }else{
            printer.printString(person.toString());
        }
        return "";
    }
}
