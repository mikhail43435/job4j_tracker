/*
package ru.job4j.tracker;
import java.util.ArrayList;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubInput;
import ru.job4j.tracker.io.StubOutput;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Store;

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
        Store memTracker = new SqlTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitConsoleAction(out));

        */
/*UserAction[] actions = {
                new CreateAction(out),
                new ExitConsoleAction(out)
        };*//*

        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store memTracker = new SqlTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        //String replacedName = "<Item{id=1, name='New item name'}>";
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", "New item name", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditItemAction(out));
        actions.add(new ExitConsoleAction(out));

*/
/*        UserAction[] actions = {
                new EditItemAction(out),
                new ExitConsoleAction(out)
        };*//*

        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
*/
/*        UserAction[] actions = {
                new DeleteItemAction(out),
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(out));
        actions.add(new ExitConsoleAction(out));

        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenSearchItemByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1" ,"1"}
        );
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("Item 1"));
        memTracker.add(new Item("Item 2"));
        */
/*UserAction[] actions = {
                new SearchItemByIdAction(out),
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new SearchItemByIdAction(out));
        actions.add(new ExitConsoleAction(out));


        new StartUI(out).init(in, memTracker, actions);
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
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("Item 1"));
        memTracker.add(new Item("Item 2"));
        */
/*UserAction[] actions = {
                new SearchItemByNameAction(out),
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new SearchItemByNameAction(out));
        actions.add(new ExitConsoleAction(out));

        new StartUI(out).init(in, memTracker, actions);
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
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("Item 1"));
        memTracker.add(new Item("Item 2"));
        */
/*UserAction[] actions = {
                new PrintItemsAction(out),
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new PrintItemsAction(out));
        actions.add(new ExitConsoleAction(out));


        new StartUI(out).init(in, memTracker, actions);
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
        MemTracker memTracker = new MemTracker();
*/
/*        UserAction[] actions = {
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitConsoleAction(out));

        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Console close" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "1", "0"}
        );
        MemTracker memTracker = new MemTracker();
*/
/*        UserAction[] actions = {
                new ExitConsoleAction(out)
        };*//*

        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitConsoleAction(out));

        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Console close%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Console close%n"
                )
        ));
    }
}*/
