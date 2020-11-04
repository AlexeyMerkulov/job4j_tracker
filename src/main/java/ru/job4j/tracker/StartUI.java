package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Showing all items ===");
                Item[] array = tracker.findAll();
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i].toString());
                }
            } else if (select == 2) {
                System.out.println("=== Editing an Item ===");
                System.out.println("Enter Id of the required Item");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter the name of a new Item");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("The item was successfully replaced");
                } else {
                    System.out.println("Error! Id was not found");
                }
            } else if (select == 3) {
                System.out.println("=== Deleting an Item ===");
                System.out.println("Enter Id of the required Item");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("The item was successfully deleted");
                } else {
                    System.out.println("Error! Id was not found");
                }
            } else if (select == 4) {
                System.out.println("=== Finding by Id ===");
                System.out.println("Enter Id of the required Item");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Item with requested Id is not found");
                }
            } else if (select == 5) {
                System.out.println("=== Finding Item by name");
                System.out.println("Enter name of the required Item");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items != null) {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i].toString());
                    }
                } else {
                    System.out.println("Items with requested name are not found");
                    }
                } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0.Add new Item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by Id");
        System.out.println("5.Find items by name");
        System.out.println("6.Exit program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}