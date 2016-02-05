package org.epamqa.students.controller;

import org.epamqa.students.view.Printer;

import java.io.BufferedReader;

/**
 * Created by timvt on 05.02.2016.
 */
public class ActionRelocation extends Action {
    public String execute(Printer printer, BufferedReader reader) {
        boolean isOK = true;
        int result, result2;
        try{
            printer.printInputNumber();
            String inputString = reader.readLine();
            result = Integer.parseInt(inputString);
            printer.printInputNumber();
            inputString = reader.readLine();
            result2 = Integer.parseInt(inputString);
             isOK = FACTORY.getPersonDAO().swapPersons(result, result2);
        }catch (Exception e){
            printer.printInputError();
            return "";
        }
        if( !isOK ){
            printer.printInputError();
        }else{
            printer.printCorrectSwap(result, result2);
        }
        return "";
    }
}
