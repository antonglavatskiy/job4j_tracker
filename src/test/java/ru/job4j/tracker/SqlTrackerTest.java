package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        Item result = tracker.findById(item.getId());
        MatcherAssert.assertThat(result.getId(), is(item.getId()));
    }

    @Test
    public void whenTestFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        Item result = tracker.findById(item.getId());
        MatcherAssert.assertThat(result, is(item));
    }

    @Test
    public void whenTestFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        MatcherAssert.assertThat(tracker.findAll(), is(List.of(first, second)));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("First"));
        MatcherAssert.assertThat(tracker.findByName("First"), is(List.of(first, third)));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        tracker.replace(item.getId(), new Item("Item1"));
        MatcherAssert.assertThat(tracker.findById(item.getId()).getName(), is("Item1"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        tracker.delete(item.getId());
        MatcherAssert.assertThat(tracker.findById(item.getId()), is(IsNull.nullValue()));
    }

}