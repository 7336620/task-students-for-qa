package org.epamqa.students.view;

import java.io.IOException;
import java.util.Properties;

/**
 * Class for output messages for user
 */
public class Printer {

    private static final String BUNDLE_PATH = "/out";
    private static final String MESSAGE_MAIN_MENU = "message.main.menu";
    private static final String MESSAGE_EXIT = "message.out";
    private static final String MESSAGE_ERROR = "message.error";
    private static final String MESSAGE_PERSON_BRIEF = "message.person.brief";
    private static final String MESSAGE_INPUT_NUMBER = "message.input.number";
    private static final String MESSAGE_CORRECT_DELETE = "message.correct.delete";
    private static final String MESSAGE_ADD_PERSON = "message.add.person";
    private static final String MESSAGE_CORRECT_SWAP = "message.correct.swap";
    private static final String MESSAGE_CORRECT_ADD = "message.correct.add";


    private Properties dbProperties= new Properties();

    public Printer() {
        try {
            dbProperties.load(Printer.class.getResourceAsStream("/out.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printExit() {
        System.out.println(dbProperties.getProperty(MESSAGE_EXIT));
    }


    public void printMainMenu(String addCommand, String eraseCommand, String listCommand, String relocationCommand, String displayCommand, String exitCommand) {
        System.out.format(dbProperties.getProperty(MESSAGE_MAIN_MENU),
                            addCommand,eraseCommand,listCommand,relocationCommand,displayCommand,exitCommand);
        System.out.println();
    }

    public void printInputError() {
        System.out.println(dbProperties.getProperty(MESSAGE_ERROR));
    }

    public void printString(String name) {
        System.out.println(name);
    }

    public void printPersonBrief(int id, String lastName) {
        System.out.format(dbProperties.getProperty(MESSAGE_PERSON_BRIEF),
                id,lastName);
    }

    public void printInputNumber() {
        System.out.println(dbProperties.getProperty(MESSAGE_INPUT_NUMBER));
    }

    public void printCorrectDelete(String s) {
        System.out.format(dbProperties.getProperty(MESSAGE_CORRECT_DELETE),s);
        System.out.println();
    }

    public void printAddPerson() {
        System.out.println(dbProperties.getProperty(MESSAGE_ADD_PERSON));
    }

    public void printCorrectSwap( int id, int id2) {
        System.out.format(dbProperties.getProperty(MESSAGE_CORRECT_SWAP),id, id2);
        System.out.println();
    }

    public void printCorrectAdd() {
        System.out.println(dbProperties.getProperty(MESSAGE_CORRECT_ADD));
    }
}
