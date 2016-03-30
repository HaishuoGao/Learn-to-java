import java.util.Scanner;

public class PIMManager {
    static PIMTodo todo = new PIMTodo();
    static PIMNote note = new PIMNote();
    static PIMContact contact = new PIMContact();
    static PIMAppointment appointment = new PIMAppointment();

    static int pimNum = 0;

    static void printPim() {
        int j = 1;
        if (todo.todoNum > 0) {
            for (int i = 0; i < todo.todoNum; i++) {
                System.out.println("Item " + j + ":" + todo.todoString[i]);
                j++;
            }
        }
        if (note.noteNum > 0) {
            for (int i = 0; i < note.noteNum; i++) {
                System.out.println("Item " + j + ":" + note.noteString[i]);
                j++;
            }
        }
        if (contact.contactNum > 0) {
            for (int i = 0; i < contact.contactNum; i++) {
                System.out.println("Item " + j + ":" + contact.contactString[i]);
                j++;
            }
        }
        if (appointment.appointmentNum > 0) {
            for (int i = 0; i < appointment.appointmentNum; i++) {
                System.out.println("Item " + j + ":" + appointment.appointmentString[i]);
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
            case "todo": todo.createTodo(); pimNum++; break;
            case "note": note.createNote(); pimNum++; break;
            case "contact": contact.createContact(); pimNum++; break;
            case "appointment": appointment.createAppointment(); pimNum++; break;
            default: System.out.println("Input error!");
        }
    }

    static void save() { System.out.println("Items have been saved."); }

    static void load() { System.out.println("Waiting for realizing."); }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String command = " ";

        System.out.println("Welcome to PIM.");
        for(;;) {
            if (command.equals("Quit")) break;
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