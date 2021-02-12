package ru.job4j.tracker.comp;

import ru.job4j.tracker.models.Item;

import java.util.Comparator;

public class SortByNameItemAscendingID implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getId() > second.getId() ? 1 : -1;
    }
}
