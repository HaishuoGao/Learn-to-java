/**
 * @author gaohaishuo
 * @version 1.0
 * PIMContact extends PIMEntity.
 */

import javax.swing.*;

public class PIMContact extends PIMEntity {
    String firstName = "default";
    String lastName = "default";
    String email;
    public int contactNum = 0;
    public String[] contactString = new String[100];

    /**
     * @return a string include the information of PIMContact.
     */
    public String toString() { return " CONTACT" + "\n" + firstName + "\n" + lastName + "\n" + email + "\n" + Priority; }

    /**
     * GUI for creating a contact.
     */
    public void createContact() {
        try {
            String priorityFromInput = JOptionPane.showInputDialog("Enter contact priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            setPriority(priorityFromInput);

            String firstNameFromInput = JOptionPane.showInputDialog("Enter first name:");
            if (firstNameFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the first name!Use the default.");
                firstNameFromInput = "Gao";
            }
            firstName = firstNameFromInput;

            String lastNameFromInput = JOptionPane.showInputDialog("Enter last name:");
            if (lastNameFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the last name!Use the default.");
                lastNameFromInput = "Haishuo";
            }
            lastName = lastNameFromInput;

            String addressFromInput = JOptionPane.showInputDialog("Enter e-mail address:");
            if (addressFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the e-mail address!Use the default.");
                addressFromInput = "gaohs7815@icloud.com";
            }
            email = addressFromInput;

            JOptionPane.showConfirmDialog(null, "Create contact successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
        contactString[contactNum] = toString();
        contactNum++;
    }
}

