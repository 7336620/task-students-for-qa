package org.epamqa.students;

import org.epamqa.students.controller.InputController;
import org.epamqa.students.model.Processing;
import org.epamqa.students.view.Printer;

/**
 * Created by timvt on 05.02.2016.
 */
public class Runner {
    /**
     * in main method we create objects of classes and giving control to created
     * objects
     *
     * @param args - command line arguments
     */
    public static void main(String[] args) {

        Processing proc = new Processing();
        Printer printer = new Printer();
        InputController controller = new InputController(proc, printer);

        try {
            controller.go();
        } catch (Exception ex) {
            printer.printExit();
        }

    }
}
