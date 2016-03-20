// Note items must be PIMEntites defined in a class named PIMNote. 
// Each note item must have a priority (a string), 
// and a string that contains the actual text of the note.

public class PIMNote extends PIMEntity {
    String noteContent;

    public void fromString(String s) {
        noteContent = s;
    }

    public String toString() {
        return "NOTE " + Priority +" " + noteContent;
    }
}
