import java.util.Scanner;

//*********************************************Solution
/*
 * @author mehra
 * This program uses a linked list implementation to store the tasks in the ToDo List.
 * The `Task` class represents a task and has fields for description, due date, and status.
 * The `ToDoList` class contains methods for adding tasks, showing all tasks, marking tasks
 * as completed, and filtering tasks by status.
 * The class `ToDoListApp` provides a command-line interface for the user to interact
 * with the ToDo List and performs the necessary operations based on user input.
 * The `start` method will be called in the `DriverMain` class.
 * This will allow you to add a task, load default tasks, show all tasks, mark a task as
 * completed, filter tasks by status. Simply provide the required information to perform the desired operation.
 */
//Your program will be evaluated by this class and several test cases.

public class ToDoListApp {
    private static ToDoList toDoList = new ToDoList();


    public static void start() {
        Scanner scanner = new Scanner(System.in);

        int iteration = scanner.nextInt();
        //scanner.nextLine();  // Consume newline
        int option;
        if(iteration == 1) {
            option = scanner.nextInt();
            //scanner.nextLine();  // Consume newline
            switch (option) {
                case 1:
                    scanner.nextLine();
                    addTask(scanner);
                    showAllTasks();
                    break;
                case 2:
                    loadDefaultTasks();
                    showAllTasks();
                    break;
                case 3:
                    loadDefaultTasks();
                    scanner.nextLine();
                    markTaskAsCompleted(scanner);
                    showAllTasks();
                    break;
                case 4:
                    loadDefaultTasks();
                    filterTasksByStatus(scanner);
                    break;
                case 5:
                    loadDefaultTasks();
                    scanner.nextLine();
                    addTask(scanner);
                    showAllTasks();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }else {
            option = scanner.nextInt();
            //scanner.nextLine();  // Consume newline
            switch (option) {
                case 1:
                    scanner.nextLine();
                    addTask2(scanner);
                    showAllTasks();
                    break;
                case 2:
                    loadDefaultTasks2();
                    scanner.nextLine();
                    showAllTasks();
                    break;
                case 3:
                    loadDefaultTasks2();
                    scanner.nextLine();
                    markTaskAsCompleted(scanner);
                    showAllTasks();
                    break;

                case 4:
                    loadDefaultTasks2();
                    filterTasksByStatus(scanner);
                    break;

                case 5:
                    loadDefaultTasks2();
                    loadDefaultTasks();
                    scanner.nextLine();
                    sortTasks(scanner);
                    showAllTasks();
                    break;

                case 6:
                    loadDefaultTasks2();
                    loadDefaultTasks();
                    totalNumberOfTasks();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        System.out.println();
        scanner.close();
    }

    private static void totalNumberOfTasks() {
        System.out.println(toDoList.getTasksCount());

    }

    private static void addTask(Scanner scanner) {
        String description = scanner.nextLine();
        String dueDate = scanner.nextLine();
        Task task = new Task(description, dueDate);
        toDoList.addTask(task);
    }

    private static void addTask2(Scanner scanner) {
        int taskTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        String description = scanner.nextLine();
        String dueDate = scanner.nextLine();
        Task task = null;
        switch (taskTypeChoice) {
            case 1:
                String reminderDate = scanner.nextLine();
                task = new PersonalTask(description, dueDate, reminderDate);
                break;
            case 2:
                int priorityLevel = scanner.nextInt();
                scanner.nextLine();
                task = new WorkTask(description, dueDate, priorityLevel);
                break;
            case 3:
                String shoppingList = scanner.nextLine();
                task = new ShoppingTask(description, dueDate, shoppingList);
                break;
            default:
                System.out.println("Invalid task type choice. Please try again.");
                break;
        }

        if (task != null) {
            toDoList.addTask(task);
        }
    }

    private static void addTasks(Scanner scanner, int count) {
        do{
            addTask(scanner);
            count--;
        }while(count > 0);
    }

    private static void showAllTasks() {
        toDoList.showAllTasks();
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        String description = scanner.nextLine();
        toDoList.markTaskAsCompleted(description);

    }
    private static void filterTasksByStatus(Scanner scanner) {
        int option = scanner.nextInt();
        //	scanner.nextLine();  // Consume newline

        switch (option) {
            case 1:
                toDoList.filterTasksByStatus(true);
                break;
            case 2:
                toDoList.filterTasksByStatus(false);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void sortTasks(Scanner scanner) {
        String sortBy = scanner.nextLine();//dueDate or description
        toDoList.sortTasks(sortBy);
    }

    private static void loadDefaultTasks() {
        Task task1 = new Task("Finish report", "2022-12-31");
        Task task2 = new Task("Submit assignment", "2022-11-30");
        toDoList.addTask(task1);
        toDoList.addTask(task2);
    }

    private static void loadDefaultTasks2() {
        Task task1 = new PersonalTask("Birthday Party", "2023-10-25", "2023-10-25");
        Task task2 = new WorkTask("Project Deadline", "2022-11-30", 3);
        Task task3 = new ShoppingTask("Grocery Shopping", "2023-10-28", "Apples, Bananas, Milk");
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
    }

}


		