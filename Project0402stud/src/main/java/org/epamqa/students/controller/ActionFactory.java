package org.epamqa.students.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 05.02.2016.
 */
public class ActionFactory {

    private static ActionFactory instance;

    private final Map<String, Action> actions;

    private ActionFactory() {
        actions = new HashMap<>();

        actions.put(Action.ADD_COMMAND, new ActionAdd());
        actions.put(Action.ERASE_COMMAND, new ActionErase());
        actions.put(Action.LIST_COMMAND, new ActionList());
        actions.put(Action.RELOCATION_COMMAND, new ActionRelocation());
        actions.put(Action.DISPLAY_COMMAND, new ActionFullPerson());
        actions.put(Action.EXIT_COMMAND, new ActionExit());
    }

    /**
     * Method to get single instance (singleton)
     *
     * @return
     */
    public static ActionFactory getInstance() {
        if (instance == null) {
            instance = new ActionFactory();
        }

        return instance;
    }

    /**
     * Method to get action instance, depending on input string
     *
     * @param action name of action
     * @return instance of Action class
     */
    public Action getAction(String action) {
        return actions.get(action);
    }
}