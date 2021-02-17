package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItemTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void deleteItemTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("test00"));
            String id = Integer.toString(item.getId());
            tracker.delete(id);
            assertThat(tracker.findById(id), is(nullValue()));
        }
    }

    @Test
    public void editItemTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item oldItem = tracker.add(new Item("test11_0"));
            String oldItemID = Integer.toString(oldItem.getId());
            Item newItem = new Item("test 11_1");
            tracker.replace(oldItemID, newItem);
            assertThat(tracker.findById(oldItemID).getName(), is("test 11_1"));
        }
    }

    @Test
    public void findByIdTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("test11_0"));
            String itemID = Integer.toString(item.getId());
            assertThat(tracker.findById(itemID).getId(), is(Integer.valueOf(itemID)));
        }
    }

    @Test
    public void findByNameTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("test15448948946545"));
            String itemID = Integer.toString(item.getId());
            assertThat(tracker.findByName(item.getName()).size(), is(1));
        }
    }

    @Test
    public void findAllTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findAll().size(), is(5));
        }
    }
}