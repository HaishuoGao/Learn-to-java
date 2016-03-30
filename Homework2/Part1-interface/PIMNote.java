// Note items must be PIMEntites defined in a class named PIMNote. 
// Each note item must have a priority (a string), 
// and a string that contains the actual text of the note.

import java.util.*;

public class PIMNote implements PIMEntity {
    String noteContent;
    String Priority; // every kind of item has a priority
    public int noteNum = 0;
    public String[] noteString = new String[100];

    public void PIMEntity() { Priority = "normal"; }

    // priority can be established via this constructor.
    public void PIMEntity(String priority) { Priority =  priority; }

    // accessor method for getting the priority string
    public String getPriority() { return Priority; }
    // method that changes the priority string
    public void setPriority(String p) { Priority = p; }

    public void fromString(String s) { noteContent = s; }

    public String toString() { return "NOTE " + Priority +" " + noteContent; }

    public void createNote() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the actual text of the note:");
        fromString(s.nextLine());
        System.out.println("Enter note priority:");
        String priority = s.nextLine();
        setPriority(priority);
        noteString[noteNum] = toString();
        noteNum++;
    }
}
