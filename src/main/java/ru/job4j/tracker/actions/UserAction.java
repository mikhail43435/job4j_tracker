package ru.job4j.tracker.actions;

import ru.job4j.tracker.models.Store;
import ru.job4j.tracker.io.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Store memTracker) throws Exception;
}