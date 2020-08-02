package ru.job4j.tracker;

//import java.util.Scanner;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new PrintItemsAction(),
                new EditItemAction(),
                new DeleteItemAction(),
                new SearchItemByIdAction(),
                new SearchItemByNameAction(),
                new ExitConsoleAction(),
        };
        new StartUI().init(input, tracker, actions);
    }
}
