import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Collections;
import java.util.LinkedList;
/**
 * @author mehra
 * This class represents a ToDoList and provides methods to perform
 * various operations on the list.
 * Please implement the provided methods and add appropriate comments for each method.
 *
 */
class ToDoList {
    private Node head;
    private int taskCount;


    /*
     * @author mehra
     * The class has a private inner class named Node, which represents
     * a node in the linked list.
     * Each node contains a Task object and a reference to the next
     * node in the list.
     */
    private class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    /*
     * Write appropriate comment:
     this function adds task to list
     */
    public void addTask(Task task) {
        if (task == null) { // null check
            System.out.println("Task cannot be null.");
            return;
        }

        Node newNode = new Node(task);
        taskCount++; // Increase task count

        if (head == null) {
            // If the list is empty, the new node becomes the head
            head = newNode;
        } else {
            // Otherwise, find the last node and append the new node
            Node last = findLastNode();
            last.next = newNode;
        }
    }
    private Node findLastNode() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /*
     * This method is responsible for displaying all tasks within the list.
     * If the list is empty, it will print "No tasks found".
     * Note: You must use the provided toString() method of the Task class to format the task details correctly.
     *
     * Write appropriate comment:
     this one prints all the tasks
     *
     */
    public void showAllTasks() {
        if (isEmpty()) { // check if empty
            System.out.println("No tasks found");
            return;
        }
        printTasksFrom(head); // helper function call
    }
    private boolean isEmpty() {// check empty
        return taskCount == 0;
    }
    private void printTasksFrom(Node node) {
        if (node == null) { // null check
            return;
        }
        System.out.println(node.task); // print recursively
        printTasksFrom(node.next);
    }

    /*
     * This method marks a task as completed based on its description.
     * If a match is not found it will print "Task not found", otherwise "Task marked as completed"
     * Note: You must use the override equals() method of the Task class to search the task, to get the full credit.
     *
     * Write appropriate comment:
     this function takes a description and if it matches then its marked
     *
     */
    public void markTaskAsCompleted(String description) {
        Node current = head; // make node
        boolean found = false; // bool
        while (current != null) { // traverse thru the list
            if (current.task.getDescription().equals(description)) { // see if given description,
                // is equal
                current.task.markCompleted(); // mark completed
                found = true; // set true
            }
            current = current.next; // point to next
        }
        if(!found){ // if not found
            System.out.println("Task not found");
        }
        else {
            System.out.println("Task marked as completed");
        }
    }


    /*
     * This method filters the tasks based on their completion status.
     * If a match is not found it will print "No tasks found".
     * Note: You must use the provided toString() method of the Task class to format the task details correctly.
     * Write appropriate comment:
     this function filters out the completed and pending by seeing if they are completed
     */
    public void filterTasksByStatus(boolean completed) {
        //Write your code here
        boolean found = false; // bool for printing
        Node current = head; // node
        while(current != null){ // traverse
            if(current.task.isCompleted() == completed){ // see if completed
                System.out.println(current.task.toString()); // print to String
                found = true; // set true
            }
            current = current.next; // point to next
        }
        if(!found){ // if not found
            System.out.println("No tasks found");
        }
    }

    /*
     * This method checks if a given task is present in the list.
     * Note: You must use the overrides equals() method of the Task class to search the task, to get the full credit.
     *
     * Write appropriate comment:
     this sees if theres functions in the list
     */
    public Boolean containsTask(Task task1) {
        Node current = head; // node
        while (current != null) { // traverse
            if (task1.equals(current)) { // see if task1 equal current
                return true; // set true
            }
            current = current.next; //point to next
        }
        return false;
    }

    /*
     * Write appropriate comment:
     *
     */
    public Integer getTasksCount() {
        return taskCount; // return count
    }



    /*
     * Write appropriate comment:
     *
     */
    public void sortTasks(String sortBy) {
        Task.sortingCriterion = sortBy;

        Node current = head;// count number of task in list
        int count = 0;
        while(current != null){
            count ++;
            current = current.next;
        }
        for(int i = 0; i < count; i++){// do sort
            Node curr = head;
            while(curr != null && curr.next != null){
                // Compare adjacent tasks and swap
                if(curr.task.compareTo(curr.next.task) > 0){
                    // swap task
                    Task temp = curr.task;
                    curr.task = curr.next.task;
                    curr.next.task = temp;
                }
                curr = curr.next;
            }
        }
    }


}



