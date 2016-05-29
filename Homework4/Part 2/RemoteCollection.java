/**
 * @author gaohaishuo
 * @version 1.0
 * RemoteCollection implements RemotePIMCollection.
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RemoteCollection implements RemotePIMCollection {
    String filePath = null;
    String[] fileStringByLine = null;

    RemoteCollection() {

    }

    /**
     * Init.
     * @param userName
     */
    RemoteCollection(String userName) {
        filePath = "PIMEntityBy" + userName + ".data";
        if (userName.isEmpty()) {
            filePath = "PIMEntity.data";
        }
        fileStringByLine = ReadFromeFile(filePath).split("\n");
    }

    /**
     * Read from a file to a String.
     * @param filePath
     * @return
     */
    String ReadFromeFile(String filePath) {
        FileReader reader;
        String result = null;
        try {
            reader = new FileReader(filePath);
            char[] buf = new char[1024];
            int temp = reader.read(buf);
            result = new String(buf,0,temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList getTodos() throws IOException {
        ArrayList<String> todoDate = new ArrayList<>();
        ArrayList<String> todoContent = new ArrayList<>();
        ArrayList<String> todoPriority = new ArrayList<>();
        ArrayList<String> todos = new ArrayList<>();
        int todoNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("TODO")) {
                todoDate.add(fileStringByLine[i + 1]);
                todoContent.add(fileStringByLine[i + 2]);
                todoPriority.add(fileStringByLine[i + 3]);
                todoNum += 1;
            }
        }

        for (int i = 0; i < todoNum; i++) {
            todos.add(todoDate.get(i) + "\n" + todoContent.get(i) + "\n" + todoPriority.get(i) + "\n");
        }

        return todos;
    }

    @Override
    public ArrayList getAppointments() throws IOException {
        ArrayList<String> appointmentDate = new ArrayList<>();
        ArrayList<String> appointmentDescript = new ArrayList<>();
        ArrayList<String> appointmentPriority = new ArrayList<>();
        ArrayList<String> appointments = new ArrayList<>();
        int appointmentNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("APPOINTMENT")) {
                appointmentDate.add(fileStringByLine[i + 1]);
                appointmentDescript.add(fileStringByLine[i + 2]);
                appointmentPriority.add(fileStringByLine[i + 3]);
                appointmentNum += 1;
            }
        }

        for (int i = 0; i < appointmentNum; i++) {
            appointments.add(appointmentDate.get(i) + "\n" + appointmentDescript.get(i) + "\n" + appointmentPriority.get(i) + "\n");
        }

        return appointments;
    }

    @Override
    public ArrayList getItemsForDate(String data) throws IOException {
        ArrayList<String> todos = getTodos();
        ArrayList<String> appointments = getAppointments();
        ArrayList<String> itemsForData = new ArrayList<>();

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).toString().contains(data)) {
                String[] temp = todos.get(i).toString().split("\n");
                itemsForData.add(temp[1] + "\n" + temp[2]);
            }
        }

        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).toString().contains(data)) {
                String[] temp = appointments.get(i).toString().split("\n");
                itemsForData.add(temp[1] + "\n" + temp[2]);
            }
        }

        return itemsForData;
    }

    @Override
    public ArrayList getNotes() throws IOException {
        ArrayList<String> noteContent = new ArrayList<>();
        ArrayList<String> notePriority = new ArrayList<>();
        ArrayList<String> notes = new ArrayList<>();
        int noteNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("NOTE")) {
                noteContent.add(fileStringByLine[i + 1]);
                notePriority.add(fileStringByLine[i + 2]);
                noteNum += 1;
            }
        }

        for (int i = 0; i < noteNum; i++) {
            notes.add(noteContent.get(i) + "\n" + notePriority.get(i) + "\n");
        }

        return notes;
    }

    @Override
    public ArrayList getContacts() throws IOException {
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> contactPriority = new ArrayList<>();
        ArrayList<String> contacts = new ArrayList<>();
        int contactNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("TODO")) {
                firstName.add(fileStringByLine[i + 1]);
                lastName.add(fileStringByLine[i + 2]);
                email.add(fileStringByLine[i + 3]);
                contactPriority.add(fileStringByLine[i + 4]);
                contactNum += 1;
            }
        }

        for (int i = 0; i < contactNum; i++) {
            contacts.add(firstName.get(i) + "\n" + lastName.get(i) + "\n" + email.get(i) + "\n" + contactPriority.get(i) + "\n");
        }

        return contacts;
    }
}
