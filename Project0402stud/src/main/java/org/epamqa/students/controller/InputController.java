package org.epamqa.students.controller;

import org.epamqa.students.model.Processing;
import org.epamqa.students.view.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Администратор on 04.02.2016.
 */
public class InputController {

    private Processing proc;
    private Printer printer;
    private BufferedReader reader;
    private ActionFactory actionFactory;

    public InputController(Processing proc, Printer printer) {
        this.proc = proc;
        this.printer = printer;
        reader = new BufferedReader(new InputStreamReader(System.in));
        actionFactory = actionFactory.getInstance();
    }

    /**
     * Main function that controls user Input
     */
    public void go() {
        String inputString = "";
        do{
            printer.printMainMenu(Action.ADD_COMMAND,Action.ERASE_COMMAND,Action.LIST_COMMAND,
                    Action.RELOCATION_COMMAND,Action.DISPLAY_COMMAND,Action.EXIT_COMMAND);
            try{
                inputString = reader.readLine();
            }catch (IOException e){
                printer.printInputError();
                continue;
            }
            Action currentAction = actionFactory.getAction(inputString);
            if(currentAction == null){
                printer.printInputError();
            }else{
                currentAction.execute(printer, reader);
            }
        }while (true);

    }
}
