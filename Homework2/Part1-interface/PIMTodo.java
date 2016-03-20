// Todo items must be PIMEntites defined in a class named PIMTodo. 
// Each todo item must have a priority (a string), 
// a date and a string that contains the actual text of the todo item.

public class PIMTodo implements Data, PIMEntity {
    String todoContent;
    String todoData = "03/25/2013";
    String Priority; // every kind of item has a priority

    public void PIMEntity() {
        Priority = "normal";
    }

    // priority can be established via this constructor.
    public void PIMEntity(String priority) {
        Priority =  priority;
    }

    // accessor method for getting the priority string
    public String getPriority() {
        return Priority;
    }
    // method that changes the priority string
    public void setPriority(String p) {
        Priority = p;
    }

    public void setData(String s) {
        todoData = s;
    }
    public void fromString(String s) {
        todoContent = s;
    }

    public String toString() {
        return  "TODO " + Priority +" " + todoData +" " + todoContent;
    }
}
