/**
 * @author gaohaishuo
 * @version 1.0
 * PIMNote extends PIMEntity.
 */

import javax.swing.*;

public class PIMNote extends PIMEntity {
    String noteContent;
    public int noteNum = 0;
    public String[] noteString = new String[100];

    /**
     * Give a string in noteContent.
     * @param s
     */
    public void setContent(String s) { noteContent = s; }

    /**
     * @return a string include the information of PIMNote.
     */
    public String toString() { return " NOTE\n" + noteContent + "\n" + Priority; }

    /**
     * GUI for creating a note.
     */
    public void createNote() {
        try {
            String textFromInput = JOptionPane.showInputDialog("Enter the actual text of the note:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some notes here...";
            }
            setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter note priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            setPriority(priorityFromInput);

            JOptionPane.showConfirmDialog(null, "Create note successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
        noteString[noteNum] = toString();
        noteNum++;
    }
}
