package ru.job4j.tracker.models;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс хранилища
 */

public interface Store extends AutoCloseable {

    void init() throws SQLException;

    Item add(Item item);

    boolean replace(String id, Item item);

    boolean delete(String id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(String id) throws SQLException;
}