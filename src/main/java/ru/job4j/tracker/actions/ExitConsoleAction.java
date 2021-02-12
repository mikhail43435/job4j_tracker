package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class ExitConsoleAction implements UserAction {
    private final Output out;

    public ExitConsoleAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Console close";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws Exception {
        memTracker.close();
        System.out.println("Connecting is closed");
        return false;
    }
}

