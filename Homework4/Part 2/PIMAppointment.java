/**
 * @author gaohaishuo
 * @version 1.0
 * PIMAppointment extends PIMEntity implements Data.
 */

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMAppointment extends PIMEntity implements Data {
    String description;
    String appointmentData = "03/25/2013";
    public int appointmentNum = 0;
    public String[] appointmentString = new String[100];

    /**
     * Give a string in description.
     * @param s
     */
    public void setContent(String s) { description = s; }

    /**
     * @return a string include the information of PIMAppointment.
     */
    public String toString() { return " APPOINTMENT" + "\n" + appointmentData + "\n" + description + "\n" + Priority; }

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
        appointmentData = s;
    }

    /**
     * GUI for creating an appointment.
     */
    public void createAppointment() {
        try {
            String dateFromInput = JOptionPane.showInputDialog("Enter date for appointment item(mm/dd/yyyy):");
            if (dateFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the date!Use the default.");
                dateFromInput = "05/10/2016";
            }
            setData(dateFromInput);

            String textFromInput = JOptionPane.showInputDialog("Enter appointment description:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some appointment here...";
            }
            setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter appointment priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            setPriority(priorityFromInput);

            JOptionPane.showConfirmDialog(null, "Create appointment successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
        appointmentString[appointmentNum] = toString();
        appointmentNum++;
    }
}