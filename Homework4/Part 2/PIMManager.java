/**
 * @author gaohaishuo
 * @version 1.0
 * This class is to manager the main function of this program.
 */

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PIMManager {
    static PIMTodo todo = new PIMTodo();
    static PIMNote note = new PIMNote();
    static PIMContact contact = new PIMContact();
    static PIMAppointment appointment = new PIMAppointment();

    static String[] pimEntities = new String[100];

    static String arrayListToString(ArrayList<String> arrayList) {
        String string = new String();
        for (int i = 0; i < arrayList.size(); i++) {
            string = string.concat(String.valueOf(i + 1)+ "." + " " + arrayList.get(i));
        }
        return string;
    }

    /**
     * Function to edit todos.
     * @throws IOException
     */
    static void editTodo() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        ArrayList todos = pimCollection.getTodos();

        if (todos.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No TODO item to edit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        Object[] selectValues = new Object[10];
        for (int i = 0; i < todos.size(); i++) {
            selectValues[i] = i + 1;
        }
        JTextArea todoText = new JTextArea(arrayListToString(todos));
        Object todoNum = JOptionPane.showInputDialog(null,todoText,"Choose which to edit.",JOptionPane.INFORMATION_MESSAGE,
                null,selectValues,"1");

        PIMTodo tempTodo = new PIMTodo();
        try {
            String dateFromInput = JOptionPane.showInputDialog("Enter date for todo item(mm/dd/yyyy):");
            if (dateFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the date!Use the default.");
                dateFromInput = "05/10/2016";
            }
            tempTodo.setData(dateFromInput);

            String textFromInput = JOptionPane.showInputDialog("Enter todo text:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some todo here...";
            }
            tempTodo.setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter todo priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            tempTodo.setPriority(priorityFromInput);
            todo.todoString[Integer.parseInt(String.valueOf(todoNum)) - 1] = tempTodo.toString();
            JOptionPane.showConfirmDialog(null, "Edit todo successfully!", "Confirm", JOptionPane.DEFAULT_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
    }

    /**
     * Function to edit notes.
     * @throws IOException
     */
    static void editNote() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        ArrayList notes = pimCollection.getNotes();

        if (notes.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No NOTE item to edit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        Object[] selectValues = new Object[10];
        for (int i = 0; i < notes.size(); i++) {
            selectValues[i] = i + 1;
        }
        JTextArea noteText = new JTextArea(arrayListToString(notes));
        Object noteNum = JOptionPane.showInputDialog(null,noteText,"Choose which to edit.",JOptionPane.INFORMATION_MESSAGE,
                null,selectValues,"1");

        PIMNote tempNote = new PIMNote();
        try {
            String textFromInput = JOptionPane.showInputDialog("Enter the actual text of the note:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some notes here...";
            }
            tempNote.setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter note priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            tempNote.setPriority(priorityFromInput);
            note.noteString[Integer.parseInt(String.valueOf(noteNum)) - 1] = tempNote.toString();
            JOptionPane.showConfirmDialog(null, "Create note successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
    }

    /**
     * Function to edit contacts.
     * @throws IOException
     */
    static void editContact() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        ArrayList contacts = pimCollection.getContacts();

        if (contacts.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No CONTACT item to edit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        Object[] selectValues = new Object[10];
        for (int i = 0; i < contacts.size(); i++) {
            selectValues[i] = i + 1;
        }
        JTextArea contactText = new JTextArea(arrayListToString(contacts));
        Object contactNum = JOptionPane.showInputDialog(null,contactText,"Choose which to edit.",JOptionPane.INFORMATION_MESSAGE,
                null,selectValues,"1");

        PIMContact tempContact = new PIMContact();
        try {
            String priorityFromInput = JOptionPane.showInputDialog("Enter contact priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            tempContact.setPriority(priorityFromInput);

            String firstNameFromInput = JOptionPane.showInputDialog("Enter first name:");
            if (firstNameFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the first name!Use the default.");
                firstNameFromInput = "Gao";
            }
            tempContact.firstName = firstNameFromInput;

            String lastNameFromInput = JOptionPane.showInputDialog("Enter last name:");
            if (lastNameFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the last name!Use the default.");
                lastNameFromInput = "Haishuo";
            }
            tempContact.lastName = lastNameFromInput;

            String addressFromInput = JOptionPane.showInputDialog("Enter e-mail address:");
            if (addressFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the e-mail address!Use the default.");
                addressFromInput = "gaohs7815@icloud.com";
            }
            tempContact.email = addressFromInput;
            contact.contactString[Integer.parseInt(String.valueOf(contactNum)) - 1] = tempContact.toString();
            JOptionPane.showConfirmDialog(null, "Edit contact successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
    }

    /**
     * Function to edit appointments.
     * @throws IOException
     */
    static void editAppointment() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        ArrayList appointments = pimCollection.getAppointments();

        if (appointments.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No APPOINTMENT item to edit!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return ;
        }

        Object[] selectValues = new Object[10];
        for (int i = 0; i < appointments.size(); i++) {
            selectValues[i] = i + 1;
        }
        JTextArea appointmentText = new JTextArea(arrayListToString(appointments));
        Object appointmentNum = JOptionPane.showInputDialog(null,appointmentText,"Choose which to edit.",JOptionPane.INFORMATION_MESSAGE,
                null,selectValues,"1");

        PIMAppointment tempAppointment = new PIMAppointment();
        try {
            String dateFromInput = JOptionPane.showInputDialog("Enter date for appointment item(mm/dd/yyyy):");
            if (dateFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the date!Use the default.");
                dateFromInput = "05/10/2016";
            }
            tempAppointment.setData(dateFromInput);

            String textFromInput = JOptionPane.showInputDialog("Enter appointment description:");
            if (textFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the text!Use the default.");
                textFromInput = "Some appointment here...";
            }
            tempAppointment.setContent(textFromInput);

            String priorityFromInput = JOptionPane.showInputDialog("Enter appointment priority:");
            if (priorityFromInput.isEmpty()) {
                JOptionPane.showConfirmDialog(null, "You did\'t input the priority!Use the default.");
                priorityFromInput = "Normal";
            }
            tempAppointment.setPriority(priorityFromInput);
            appointment.appointmentString[Integer.parseInt(String.valueOf(appointmentNum)) - 1] = tempAppointment.toString();
            JOptionPane.showConfirmDialog(null, "Edit appointment successfully!", "Confirm", JOptionPane.OK_OPTION);
        }
        catch(Exception e) {
            System.out.println("No Input!");
        }
    }

    /**
     * Function to view todos.
     * @throws IOException
     */
    static void viewTodo() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        String todos = arrayListToString(pimCollection.getTodos());
        JOptionPane.showMessageDialog(null,todos,"TODO",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Function to view notes.
     * @throws IOException
     */
    static void viewNote() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        String notes = arrayListToString(pimCollection.getNotes());
        JOptionPane.showMessageDialog(null,notes,"NOTE",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Function to view contacts.
     * @throws IOException
     */
    static void viewContact() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        String contacts = arrayListToString(pimCollection.getContacts());
        JOptionPane.showMessageDialog(null,contacts,"CONTACT",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Function to view appointments.
     * @throws IOException
     */
    static void viewAppointment() throws IOException {
        RemoteCollection pimCollection = new RemoteCollection();
        String appointments = arrayListToString(pimCollection.getAppointments());
        JOptionPane.showMessageDialog(null,appointments,"APPOINTMENT",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Write the pims to local file.
     */
    static void save() {
        int j = 0;

        if (todo.todoNum > 0) {
            for (int i = 0; i < todo.todoNum; i++) {
                pimEntities[j] = "Item " + ":" + todo.todoString[i] + "\n";
                j++;
            }
        }
        if (note.noteNum > 0) {
            for (int i = 0; i < note.noteNum; i++) {
                pimEntities[j] = "Item " + ":" + note.noteString[i] + "\n";
                j++;
            }
        }
        if (contact.contactNum > 0) {
            for (int i = 0; i < contact.contactNum; i++) {
                pimEntities[j] = "Item " + ":" + contact.contactString[i] + "\n";
                j++;
            }
        }
        if (appointment.appointmentNum > 0) {
            for (int i = 0; i < appointment.appointmentNum; i++) {
                pimEntities[j] = "Item " + ":" + appointment.appointmentString[i] + "\n";
                j++;
            }
        }

        try{
            String filePath = "PIMEntity.data";

            File file = new File(filePath);

            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            for (int i = 0; i < pimEntities.length; i++) {
                if (pimEntities[i] != null) {
                    System.out.println(pimEntities[i]);
                }
                else {
                    break;
                }
            }
            //true = append file
            FileOutputStream out = new FileOutputStream(file,true);

            for (int i = 0; i < pimEntities.length; i++) {
                if (pimEntities[i] != null) {
                    out.write(pimEntities[i].getBytes());
                }
                else {
                    break;
                }
            }
            out.close();

            System.out.println("Save to file successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Create pims.
     * @param command
     */
    static void create(String command) {
        switch(command) {
            case "TODO": todo.createTodo(); break;
            case "NOTE": note.createNote(); break;
            case "CONTACT": contact.createContact(); break;
            case "APPOINTMENT": appointment.createAppointment(); break;
        }
    }

    /**
     * Load data from local file.
     * @return
     */
    static String load() {
        String filepath = JOptionPane.showInputDialog("Please input the file path:");
        return filepath;
    }

}
