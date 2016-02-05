package org.epamqa.students.controller;

import org.epamqa.students.view.Printer;

import java.io.BufferedReader;

/**
 * Created by timvt on 05.02.2016.
 */
public class ActionExit extends Action {
    @Override
    public String execute(Printer printer, BufferedReader reader) {
        printer.printString(this.getClass().getName() );
            throw new ExitException();
    }

}
