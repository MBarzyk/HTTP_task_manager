package com.javagda25.tasks;

import java.util.Scanner;

public class ScannerLoader {
    private Scanner scanner = new Scanner(System.in);

    public Task editTask() {
        Task taskToEdit = new Task();
        System.out.println("Which task would you like to edit? (give id)");
        String idString = scanner.nextLine();
        Long id = null;
        do {
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
//            taskToEdit.setCreationTime(LocalDateTime.now());
        String line = null;
        System.out.println("Would you like to set the task as done? (yes/no)");
        do {
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
}
