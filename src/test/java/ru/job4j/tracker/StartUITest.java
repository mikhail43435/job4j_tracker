package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

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

    /*@Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        *//* Добавим в tracker новую заявку *//*
        Item item = tracker.add(new Item("Replaced item"));
        *//* Входные данные должны содержать ID добавленной заявки item.getId() *//*
        String replacedName = "<Item{id=1, name='New item name'}>";
        Input in = new StubInput(
                new String[] {"0" , "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new EditItemAction(),
                new ExitConsoleAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(replacedName));
    }*/

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
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