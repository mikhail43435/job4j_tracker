package ru.job4j.tracker.loadtests;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.MemTracker;

public enum TrackerSingleEagerLoad {
    INSTANCE; // здесь мы указываем перечисления.
    // Конструкторы и методы.
    private MemTracker memTracker = new MemTracker();

    public Item add(Item model) {
        return model;
    }

    public MemTracker getMemTracker() {
        return memTracker;
    }
}