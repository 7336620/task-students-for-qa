package org.epamqa.students.controller;

import org.epamqa.students.model.entity.Person;
import org.epamqa.students.view.Printer;

import java.io.BufferedReader;

/**
 * Created by timvt on 05.02.2016.
 */
public class ActionAdd extends Action {
    public String execute(Printer printer, BufferedReader reader) {
        boolean isOK = false;
        printer.printAddPerson();
        String  inputString[]= new String[4];
        String emptyStr = "                                                           ";
        try {
            inputString[0] = (reader.readLine()+emptyStr).substring(0,45).trim();
            inputString[1] = (reader.readLine()+emptyStr).substring(0,45).trim();
            inputString[2] = reader.readLine().trim().toUpperCase();
            inputString[3] = reader.readLine().trim();
            char professionCode = inputString[2].charAt(0);
            float weight = Float.parseFloat(inputString[3]);
            isOK = FACTORY.getPersonDAO().createPerson(new Person(0,inputString[0],inputString[1],professionCode,weight));
        } catch (Exception e) {
            e.printStackTrace();
            printer.printInputError();
            return "";
        }
        if(!isOK){
            printer.printInputError();
        }else{
            printer.printCorrectAdd();
        }
        return "";
    }
}
