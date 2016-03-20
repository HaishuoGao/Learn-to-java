import java.util.*;

public class PIMManager {
    static PIMTodo todo = new PIMTodo();
    static PIMNote note = new PIMNote();
    static PIMContact contact = new PIMContact();
    static PIMAppointment appointment = new PIMAppointment();
    static int pimNum = 0;
    static int todoNum = 0;
    static int noteNum = 0;
    static int contactNum = 0;
    static int appointmentNum = 0;
    static String[] todoString = new String[100];
    static String[] noteString = new String[100];
    static String[] contactString = new String[100];
    static String[] appointmentString = new String[100];

    static void createTodo() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter date for todo item:");
        todo.setData(s.nextLine());
        System.out.println("Enter todo text:");
        todo.fromString(s.nextLine());
        System.out.println("Enter todo priority:");
        String priority = s.nextLine();
        todo.setPriority(priority);
        todoString[todoNum] = todo.toString();
        todoNum++;
    }

    static void createNote() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the actual text of the note:");
        note.fromString(s.nextLine());
        System.out.println("Enter note priority:");
        String priority = s.nextLine();
        note.setPriority(priority);
        noteString[noteNum] = note.toString();
        noteNum++;
    }

    static void createContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter contact priority:");
        String priority = s.nextLine();
        contact.setPriority(priority);
        System.out.println("Enter first name:");
        contact.firstName = s.nextLine();
        System.out.println("Enter last name:");
        contact.lastName = s.nextLine();
        System.out.println("Enter e-mail address:");
        contact.fromString(s.nextLine());
        contactString[contactNum] = contact.toString();
        contactNum++;
    }

    static void createAppointment() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter date for appointment item:");
        appointment.setData(s.nextLine());
        System.out.println("Enter appointment description:");
        appointment.fromString(s.nextLine());
        System.out.println("Enter appointment priority:");
        String priority = s.nextLine();
        appointment.setPriority(priority);
        appointmentString[appointmentNum] = appointment.toString();
        appointmentNum++;
    }

    static void printPim() {
        int j = 1;
        if (todoNum > 0) {
            for (int i = 0; i < todoNum; i++) {
                System.out.println("Item " + j + ":" + todoString[i]);
                j++;
            }
        }
        if (noteNum > 0) {
            for (int i = 0; i < noteNum; i++) {
                System.out.println("Item " + j + ":" + noteString[i]);
                j++;
            }
        }
        if (contactNum > 0) {
            for (int i = 0; i < contactNum; i++) {
                System.out.println("Item " + j + ":" + contactString[i]);
                j++;
            }
        }
        if (appointmentNum > 0) {
            for (int i = 0; i < appointmentNum; i++) {
                System.out.println("Item " + j + ":" + appointmentString[i]);
                j++;
            }
        }

    }
    static void list() {
        System.out.println("There are " + pimNum + " items.");
        if (pimNum > 0) printPim();
    }

    static void create() {
        System.out.println("Enter an item type ( todo, note, contact or appointment )");
        Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        switch(command) {
            case "todo": createTodo(); pimNum++; break;
            case "note": createNote(); pimNum++; break;
            case "contact": createContact(); pimNum++; break;
            case "appointment": createAppointment(); pimNum++; break;
            default: System.out.println("Input error!");
        }
    }

    static void save() {
        System.out.println("Items have been saved.");
        //
    }

    static void load() {
        System.out.println("Waiting for realizing.");
        //
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String command = " ";

        System.out.println("Welcome to PIM.");
        for(;;) {
            if (command.equals("Quit")) {
                break;
            }
            System.out.println("---Enter a command (suported commands are List Create Save Load Quit)---");
            command = s.nextLine();
            switch(command) {
                case "List": list(); break;
                case "Create": create(); break;
                case "Save": save(); break;
                case "Load": load(); break;
                case "Quit": System.out.println("Thank you for using!"); break;
                default: System.out.println("Command Not Find!"); break;
            }
        }
    }
}