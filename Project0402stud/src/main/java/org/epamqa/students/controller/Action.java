package org.epamqa.students.controller;

import org.epamqa.students.model.dao.DaoFactory;
import org.epamqa.students.view.Printer;

import java.io.BufferedReader;

/**
 * Created by Администратор on 05.02.2016.
 */
public abstract class Action {

    static final String ADD_COMMAND = "1";
    static final String ERASE_COMMAND = "2";
    static final String LIST_COMMAND = "3";
    static final String RELOCATION_COMMAND = "4";
    static final String DISPLAY_COMMAND = "5";
    static final String EXIT_COMMAND = "0";


    static final DaoFactory FACTORY = DaoFactory.getFactory(DaoFactory.DAOType.MYSQL);

    public abstract String execute(Printer printer, BufferedReader reader);
}