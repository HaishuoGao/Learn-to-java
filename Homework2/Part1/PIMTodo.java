// Todo items must be PIMEntites defined in a class named PIMTodo.
// Each todo item must have a priority (a string),
// a date and a string that contains the actual text of the todo item.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMTodo extends PIMEntity implements Data {
    String todoContent;
    String todoData = "03/25/2013";
    public int todoNum = 0;
    public String[] todoString = new String[100];

    public void setData(String s) {
        String dataFormat = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Scanner str = new Scanner(System.in);
        Pattern p = Pattern.compile(dataFormat);
        do {
            Matcher m = p.matcher(s);
            boolean dateFlag = m.matches();
            if (dateFlag) break;
            System.out.println("Wrong data format,Please try again:");
            s = str.nextLine();
        } while (true);
        todoData = s;
    }

    public void fromString(String s) { todoContent = s; }

    public String toString() { return  "TODO " + Priority +" " + todoData +" " + todoContent; }

    public void createTodo() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter date for todo item(mm/dd/yyyy):");
        setData(s.nextLine());
        System.out.println("Enter todo text:");
        fromString(s.nextLine());
        System.out.println("Enter todo priority:");
        String priority = s.nextLine();
        setPriority(priority);
        todoString[todoNum] = toString();
        todoNum++;
    }
}
