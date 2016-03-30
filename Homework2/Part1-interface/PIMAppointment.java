// Appointment items must be PIMEntites defined in a class named PIMAppointment. 
// Each appointment must have a priority (a string), 
// a date and a description (a string).

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMAppointment implements PIMEntity, Data {
    String description;
    String appointmentData = "03/25/2013";
    String Priority; // every kind of item has a priority
    public int appointmentNum = 0;
    public String[] appointmentString = new String[100];

    public void PIMEntity() { Priority = "normal"; }

    // priority can be established via this constructor.
    public void PIMEntity(String priority) { Priority =  priority; }

    // accessor method for getting the priority string
    public String getPriority() { return Priority; }
    // method that changes the priority string
    public void setPriority(String p) { Priority = p; }

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

    public void fromString(String s) { description = s; }

    public String toString() { return "APPOINTMENT: " + Priority +" " + description +" " + appointmentData; }

    public void createAppointment() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter date for appointment item(mm/dd/yyyy):");
        setData(s.nextLine());
        System.out.println("Enter appointment description:");
        fromString(s.nextLine());
        System.out.println("Enter appointment priority:");
        String priority = s.nextLine();
        setPriority(priority);
        appointmentString[appointmentNum] = toString();
        appointmentNum++;
    }
}


