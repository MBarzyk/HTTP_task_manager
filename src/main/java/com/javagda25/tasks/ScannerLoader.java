package com.javagda25.tasks;

import java.util.Scanner;

public class ScannerLoader {
    private Scanner scanner = new Scanner(System.in);

    public Task editTask() {
        Task taskToEdit = new Task();
        Long id = null;
        do {
            System.out.println("Which task would you like to edit? (give id)");
            String idString = scanner.nextLine();
            try {
                id = Long.parseLong(idString);
            } catch (IllegalArgumentException iae) {
                System.err.println("Did not input a number!");
            }
        } while (id == null);
        taskToEdit.setId(id);

        System.out.println("Input new name for the task: ");
        String name = scanner.nextLine();
        taskToEdit.setName(name);
        String line = null;
        do {
            System.out.println("Would you like to set the task as done? (yes/no)");
            line = scanner.nextLine();
            switch (line) {
                case "yes":
                    taskToEdit.setDone(true);
                    break;
                case "no":
                    taskToEdit.setDone(false);
                    break;
                default:
                    System.err.println("Wrong input, try again!");
            }
        } while (line == null);
        return taskToEdit;
    }

    public Task newTask() {
        Task taskToPut = new Task();
        System.out.println("Input name for the new task: ");
        String name = scanner.nextLine();
        taskToPut.setName(name);

        return taskToPut;
    }

    public Integer returnId() {
        Integer id = null;
        do {
            System.out.println("Which task do you want to remove? (write id)");
            String stringId = scanner.nextLine();
            try {
                id = Integer.parseInt(stringId);
            } catch (IllegalArgumentException iae) {
                System.err.println("Wrong input, try again!");
            }

        } while (id == null);
        return id;
    }

    public void printDone (String uri, Manager manager) {
        manager.get(uri);

    }

    public void parser () {

    }
}
