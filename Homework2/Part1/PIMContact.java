// Contact items must be PIMEntites defined in a class named PIMContact. 
// Each contact item must have a priority (a string), 
// and strings for each of the following: first name, last name, email address.

public class PIMContact extends PIMEntity {
    String firstName = "default";
    String lastName = "default";
    String email;

    public void fromString(String s) {
        email = s;
    }

    public String toString() {
        return "CONTACT" +" " + Priority +" " + firstName +" " + lastName +" " + email;
    }
}

