// Contact items must be PIMEntites defined in a class named PIMContact. 
// Each contact item must have a priority (a string), 
// and strings for each of the following: first name, last name, email address.

import java.util.*;

public class PIMContact implements PIMEntity {
    String firstName = "default";
    String lastName = "default";
    String email;
    String Priority; // every kind of item has a priority 
    public int contactNum = 0;
    public String[] contactString = new String[100];

    public void PIMEntity() { Priority = "normal"; }

    // priority can be established via this constructor.
    public void PIMEntity(String priority) { Priority =  priority; }

    // accessor method for getting the priority string
    public String getPriority() { return Priority; }
    // method that changes the priority string
    public void setPriority(String p) { Priority = p; }

    public void fromString(String s) { email = s; }

    public String toString() { return "CONTACT" +" " + Priority +" " + firstName +" " + lastName +" " + email; }

    public void createContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter contact priority:");
        String priority = s.nextLine();
        setPriority(priority);
        System.out.println("Enter first name:");
        firstName = s.nextLine();
        System.out.println("Enter last name:");
        lastName = s.nextLine();
        System.out.println("Enter e-mail address:");
        fromString(s.nextLine());
        contactString[contactNum] = toString();
        contactNum++;
    }
}

