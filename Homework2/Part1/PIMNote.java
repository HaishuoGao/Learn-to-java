// Note items must be PIMEntites defined in a class named PIMNote.
// Each note item must have a priority (a string),
// and a string that contains the actual text of the note.

import java.util.Scanner;

public class PIMNote extends PIMEntity {
    String noteContent;
    public int noteNum = 0;
    public String[] noteString = new String[100];

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
