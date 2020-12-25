package ru.job4j.tracker;

//import java.util.Scanner;

import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            //UserAction action = actions[select];
            UserAction action = actions.get(select);   //???
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            //out.println(index + ". " + actions[index].name());
            out.println(index + ". " + actions.get(index).name());
                    //.get(index).name actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        //Input input = new ConsoleInput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new PrintItemsAction(output));
        actions.add(new EditItemAction(output));
        actions.add(new DeleteItemAction(output));
        actions.add(new SearchItemByIdAction(output));
        actions.add(new SearchItemByNameAction(output));
        actions.add(new ExitConsoleAction(output));

        System.out.println(StartUI.class.getClassLoader());

/*        UserAction[] actions = {
                new CreateAction(output),
                new PrintItemsAction(output),
                new EditItemAction(output),
                new DeleteItemAction(output),
                new SearchItemByIdAction(output),
                new SearchItemByNameAction(output),
                new ExitConsoleAction(output),
        };*/
        new StartUI(output).init(input, tracker, actions);
    }
}
