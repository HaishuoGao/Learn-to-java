// Todo items must be PIMEntites defined in a class named PIMTodo. 
// Each todo item must have a priority (a string), 
// a date and a string that contains the actual text of the todo item.

public class PIMTodo extends PIMEntity implements Data {
    String todoContent;
    String todoData = "03/25/2013";

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
