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
                new String[] {"0", "Item name", "1"}
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
        //assertThat(tracker.findById(item.getId()), is(replacedName));

        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        //assertThat(out.toString(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1" , "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
/*
    @Test
    public void whenFindBYId() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));
        Input in = new StubInput(
                new String[] {"0", "1" , "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitConsoleAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }*/

/*
    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item 1"));
        tracker.add(new Item("Item 2"));

        Item[] items = new Item[2];

        Item newItem1 = new Item();
        newItem1.setId(1);
        newItem1.setName("Item 1");
        items[0] = newItem1;

        Item newItem2 = new Item();
        newItem2.setId(2);
        newItem2.setName("Item 2");
        items[1] = newItem2;

        assertArrayEquals(tracker.findAll(), items);
    }
*/


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