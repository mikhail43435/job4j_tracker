package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;

    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}