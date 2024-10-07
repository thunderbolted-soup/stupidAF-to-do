package com.todo.cli;

import java.util.Scanner;

public class TaskManager {
    static class Task {
        String description;
        boolean isDone;
        int priority;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        static String helpCommand() {
            String helpMessage = "'add' command to add a task,\n" +
                    "'list' command to view all tasks, including completed ones,\n" +
                    "command 'exit' to stop and exit the program.";
            return helpMessage;
        }
    }
    public static String[] StringArrayExpander(String[] name, int howMuch){
        String[] tempTasks = new String[name.length + howMuch];
        System.arraycopy(name, 0, tempTasks, 0, name.length);
        return tempTasks;
    }

    public static void main(String[] args) {
        boolean keepRunning = true;
        String[] tasks = {};
        String[] doneTasks = {};
        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            System.out.println("Enter a command (help, add, list, exit)");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "exit" -> keepRunning = false;
                ////////////////////////////////////////////////////////////////////////////
                case "help" -> System.out.println(Task.helpCommand());

                ////////////////////////////////////////////////////////////////////////////
                case "add" -> {
                    System.out.println("Enter a Task description:");
                    String description = scanner.nextLine();
                    Task newTask = new Task(description);

                    boolean validPriority = false;
                    while (!validPriority) {
                        System.out.println("Specify a priority from 1 (most important) to 4 (least important):");
                        try {
                            int priority = Integer.parseInt(scanner.nextLine());
                            if (priority >= 1 && priority <= 4) {
                                newTask.priority = priority;
                                validPriority = true;
                            } else {
                                System.out.println("Invalid priority. Please enter a number between 0 and 4.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }

                    tasks = StringArrayExpander(tasks, 1);
                    tasks[tasks.length - 1] = newTask.description;
                }
                ////////////////////////////////////////////////////////////////////////////
                case "list" -> {
                    String[] tempEmptyArray = new String[0];
                    int number;
                    boolean listMenuKeeper = true;
                    String spacer = "################################";

                    while (listMenuKeeper){
                        System.out.println("Current Tasks:");
                        if (tasks == tempEmptyArray){
                            System.out.println("Well Done! You completed all");
                        } else {
                            number = 1;
                            for (Object temp : tasks){
                                System.out.println(number + ". " + temp);
                                number++;
                            }
                        }
                        System.out.println(spacer);

                        System.out.println("Completed Tasks:");
                        if (doneTasks == tempEmptyArray){
                            System.out.println("There is no completed tasks.");
                        } else {
                            number = 1;
                            for (Object temp : doneTasks){
                                System.out.println(number + ". " + temp);
                                number++;
                            }
                        }
                        System.out.println(spacer);
                        System.out.println("Enter a command (edit, remove, purge, back)");
                        String commandInListMenu = scanner.nextLine().toLowerCase();
                        switch (commandInListMenu){
                            case "edit" -> {
                                System.out.println("Enter a number of current task: ");
                                int tempEditTask = scanner.nextInt();

                            }
                            case "remove" -> {
                                
                            }
                            case "purge" -> {

                            }
                            case "back" -> {

                            }
                        }
                    }

                }
                ////////////////////////////////////////////////////////////////////////////
                default -> System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}
