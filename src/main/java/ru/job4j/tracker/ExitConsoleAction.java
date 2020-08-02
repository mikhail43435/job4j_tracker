package ru.job4j.tracker;

public class ExitConsoleAction implements UserAction {
    @Override
    public String name() {
        return "Console closed";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Console is closed");
        return false;
    }
}

