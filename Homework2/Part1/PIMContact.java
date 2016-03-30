// Contact items must be PIMEntites defined in a class named PIMContact.
// Each contact item must have a priority (a string),
// and strings for each of the following: first name, last name, email address.

import java.util.Scanner;

public class PIMContact extends PIMEntity {
    String firstName = "default";
    String lastName = "default";
    String email;
    public int contactNum = 0;
    public String[] contactString = new String[100];

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

