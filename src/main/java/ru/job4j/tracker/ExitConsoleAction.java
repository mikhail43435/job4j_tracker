package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("Console is closed");
        return false;
    }
}

