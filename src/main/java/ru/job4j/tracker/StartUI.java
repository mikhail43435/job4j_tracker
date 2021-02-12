package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.*;
import ru.job4j.tracker.models.Store;
import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker,
                     ArrayList<UserAction> actions) throws Exception {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker;
        if (selectTypeOfTrackerAction(input) == 1) {
            tracker = new MemTracker();
        } else {
            tracker = new SqlTracker();
        }
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new PrintItemsAction(output));
        actions.add(new EditItemAction(output));
        actions.add(new DeleteItemAction(output));
        actions.add(new SearchItemByIdAction(output));
        actions.add(new SearchItemByNameAction(output));
        actions.add(new ExitConsoleAction(output));
        new StartUI(output).init(input, tracker, actions);
    }

    private static int selectTypeOfTrackerAction(Input input) {
        System.out.println("Select type of tracker you would like to use...");
        System.out.println("1 - memtracker");
        System.out.println("2 - sql tracker");
        return Integer.parseInt(input.askStr("Enter position: "));
    }
}