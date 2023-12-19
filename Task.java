import java.util.*;

/**
 * This `Task` class represents a task with a description, due date,
 * and completion status.
 * Please implement the provided methods and add appropriate comments for each method.
 */

public class Task implements Comparable<Task> {
    private String description;
    private String dueDate;
    private boolean completed;

    public Task() {
        //Write your code here
        this.description = "";
        this.dueDate = "";
        this.completed = false;
    }
    /*
     * Write appropriate comment:
     * constructor
     */
    public Task(String description, String dueDate) {
        //Write your code here
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    /*
     * Write appropriate comment:
     * return the desc, getter
     */
    public String getDescription() {
        //Write your code here
        return description;
    }

    /*
     * Write appropriate comment:
     * return the duedate, getter
     */
    public String getDueDate() {
        //Write your code here
        return dueDate;
    }

    /*
     * Write appropriate comment:
     *  this bool function is used to see if yes/no the function is completed
     */
    public boolean isCompleted() {
        //Write your code here
        return completed;
    }

    /*
     * Write appropriate comment:
     * this is used to mark a task completed
     */
    public void markCompleted() {
        //Write your code here
        completed = true;
    }

    @Override
    public int compareTo(Task otherTask) {// compare task on duedate or description
        if (Task.sortingCriterion.equals("dueDate")) {
            return this.dueDate.compareTo(otherTask.dueDate);
        } else {
            return this.description.compareTo(otherTask.description);
        }
    }

    public static String sortingCriterion = "dueDate";


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        return Objects.equals(description, other.description) &&
                Objects.equals(dueDate, other.dueDate);
    }



    @Override
    public int hashCode() {
        return Objects.hash(description, dueDate);
    }




    //********************************************************* DO NOT CHANGE ***************************************************//
    /*
     * This method overrides the `toString` method from the `Object` class.
     * It returns a string representation of the task, including its description, due date, and completion status.
     *
     */
    @Override
    public String toString() {
        return "Description: " + getDescription() + "\n" +
                "Due Date: " + getDueDate() + "\n" +
                "Status: " + (isCompleted() ? "Completed" : "Pending") +
                "\n";
    }

}
class ShoppingTask extends Task{

    private String shoppingList;

    public String getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(String shoppingList) {
        this.shoppingList = shoppingList;
    }
    ShoppingTask(String description, String dueDate, String shoppingList){
        super(description, dueDate);
        this.shoppingList = shoppingList;
    }



    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShoppingTask other = (ShoppingTask) obj;
        return Objects.equals(shoppingList, other.shoppingList);
    }



    public String toString() {
        return super.toString() + "Shopping List: " + getShoppingList() + "\n" ;
    }
}
class PersonalTask extends Task{
    private String reminderDate;

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    PersonalTask(String description, String dueDate, String reminderDate){
        super(description, dueDate);
        this.reminderDate = reminderDate;
    }

    @Override
    public String toString() {
        return super.toString() + "Reminder Date: " + getReminderDate()  +"\n" ;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PersonalTask other = (PersonalTask) obj;
        return Objects.equals(reminderDate, other.reminderDate);
    }




}

class WorkTask extends Task{
    private int priorityLevel;

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    WorkTask(String description, String dueDate, int priorityLevel){
        super(description, dueDate);
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {

        return super.toString() + "Priority Level: " + Integer.toString(getPriorityLevel()) +   "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        WorkTask other = (WorkTask) obj;
        return priorityLevel == other.priorityLevel;
    }



}






