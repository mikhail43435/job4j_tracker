package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Store;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.util.Objects.nonNull;

public class SqlTracker implements Store {
    private Connection connection;

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public SqlTracker() {
        init();
    }

    public void init() {
        try (InputStream in = SqlTracker.class.
                getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists items(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (nonNull(connection)) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into items(name) values (?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                //System.out.println("ID set: " + rs.getInt(1));
                item.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result;
        try (PreparedStatement statement =
                     connection.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from items where id=?;")) {
            statement.setInt(1, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items where name=?;")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getString("name").equals(key)) {
                        items.add(new Item(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                        ));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) throws SQLException {
        Item item = null;
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items where id=?;")) {
            statement.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                        item = new Item(resultSet.getInt("id"),
                                resultSet.getString("name"));
                    }
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return item;
    }
}