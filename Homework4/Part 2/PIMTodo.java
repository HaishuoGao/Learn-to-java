/**
 * @author gaohaishuo
 * @version 1.0
 * PIMTodo extends PIMEntity implements Data.
 */

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMTodo extends PIMEntity implements Data {
    String todoContent;
    String todoData = "03/25/2013";
    public int todoNum = 0;
    public String[] todoString = new String[100];

    /**
     * Judge if the string s is a legal input.
     * @param s It is an string.
     */
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
        todoData  = s;
    }

    /**
     * Give a string in todoContent.
     * @param s
     */
    public void setContent(String s) { todoContent = s; }

    /**
     * @return a string include the information of PIMTodo.
     */
    public String toString() { return  " TODO" + "\n" + todoData + "\n" + todoContent + "\n" + Priority; }

    /**
     * GUI for creating a todo.
     */
    public void createTodo() {
        try {
            String dateFromInput = JOptionPane.showInputDialog("Enter date for todo item(mm/dd/yyyy):");
            if (dateFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the date!Use the default.");
                dateFromInput = "05/10/2016";
            }
            setData(dateFromInput);

            String textFromInput = JOptionPane.showInputDialog("Enter todo text:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some todo here...";
            }
            setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter todo priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            setPriority(priorityFromInput);

            JOptionPane.showConfirmDialog(null, "Create todo successfully!", "Confirm", JOptionPane.DEFAULT_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
        todoString[todoNum] = toString();
        todoNum++;
    }
}