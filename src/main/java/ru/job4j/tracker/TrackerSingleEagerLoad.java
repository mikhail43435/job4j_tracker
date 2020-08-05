package ru.job4j.tracker;
import ru.job4j.tracker.Item;

public enum TrackerSingleEagerLoad {
    INSTANCE; // здесь мы указываем перечисления.
    // Конструкторы и методы.
    public Item add(Item model) {
        return model;
    }
}