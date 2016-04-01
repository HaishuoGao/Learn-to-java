import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMCollection extends ArrayList implements Data{
    static String[] pimEntities = new String[100];

    PIMCollection(String[] pimEntity) {
        pimEntities = pimEntity;
    }

    public Collection getNotes() {
        List notes = new ArrayList<String>();
        for (int i = 0; i < pimEntities.length; i++) {
            if (pimEntities[i] == null)
                break;
            if (pimEntities[i].substring(7, 11) == "NOTE") {
                notes.add(pimEntities[i]);
            }
        }
        print(notes);
        return notes;
    }

    public Collection getTodos() {
        List todo = new ArrayList<String>();
        for (int i = 0; i < pimEntities.length; i++) {
            if (pimEntities[i] == null)
                break;
            if (pimEntities[i].substring(7, 11) == "TODO") {
                todo.add(pimEntities[i]);
            }
        }
        print(todo);
        return todo;
    }

    public Collection getAppointments() {
        List appointment = new ArrayList<String>();
        for (int i = 0; i < pimEntities.length; i++) {
            if (pimEntities[i] == null)
                break;
            if (pimEntities[i].substring(7, 18) == "APPOINTMENT") {
                appointment.add(pimEntities[i]);
            }
        }
        print(appointment);
        return appointment;
    }

    public  Collection getContact() {
        List contact = new ArrayList<String>();
        for (int i = 0; i < pimEntities.length; i++) {
            if (pimEntities[i] == null)
                break;
            if (pimEntities[i].substring(7, 14) == "CONTACT") {
                contact.add(pimEntities[i]);
            }
        }
        print(contact);
        return contact;
    }

    public Collection getItemsForData(String d) {
        List itemForData = new ArrayList<String>();
        for (int i = 0; i < pimEntities.length; i++) {
            if (pimEntities[i] == null)
                break;
            if (pimEntities[i].substring(12, 22) == d)
                itemForData.add(pimEntities[i]);
            if (pimEntities[i].substring(20, 30) == d)
                itemForData.add(pimEntities[i]);
        }
        print(itemForData);
        return itemForData;
    }

    public void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Override
    public void setData(String s) {

    }

    @Override
    public String setData() {
        String dataFormat = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Scanner str = new Scanner(System.in);
        String s = str.nextLine();
        Pattern p = Pattern.compile(dataFormat);
        do {
            Matcher m = p.matcher(s);
            boolean dateFlag = m.matches();
            if (dateFlag) break;
            System.out.println("Wrong data format,Please try again:");
            s = str.nextLine();
        } while (true);
        return s;
    }

}
