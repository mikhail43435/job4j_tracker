package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        //String replacedName = "<Item{id=1, name='New item name'}>";
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenSearchItemByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1" ,"1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));
        UserAction[] actions = {
                new SearchItemByIdAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Searching item by id" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
                        + "Item with id [1] has been found successfully" + System.lineSeparator()
                        + "Item{id=1, name='Item 1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Searching item by id" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
        ));
    }

    @Test
    public void whenSearchItemByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item 1" ,"1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));
        UserAction[] actions = {
                new SearchItemByNameAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Searching item by name" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
                        + "Item(s) with name [Item 1] has been found successfully" + System.lineSeparator()
                        + "Printing found items..." + System.lineSeparator()
                        + "Item{id=1, name='Item 1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Searching item by name" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));
        UserAction[] actions = {
                new PrintItemsAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Printing all item's list" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
                        + "Item{id=1, name='Item 1'}" + System.lineSeparator()
                        + "Item{id=2, name='Item 2'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Printing all item's list" + System.lineSeparator()
                        + "1. Console close" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Console close" + System.lineSeparator()
        ));
    }
}