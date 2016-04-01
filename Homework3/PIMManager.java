import java.util.Scanner;

public class PIMManager {
    static PIMTodo todo = new PIMTodo();
    static PIMNote note = new PIMNote();
    static PIMContact contact = new PIMContact();
    static PIMAppointment appointment = new PIMAppointment();

    static int pimNum = 0;
    static String[] pimEntities = new String[100];

    static void savePim() {
        int j = 1;
        if (todo.todoNum > 0) {
            for (int i = 0; i < todo.todoNum; i++) {
                pimEntities[j - 1] = "Item " + j + ":" + todo.todoString[i];
                j++;
            }
        }
        if (note.noteNum > 0) {
            for (int i = 0; i < note.noteNum; i++) {
                pimEntities[j - 1] = "Item " + j + ":" + note.noteString[i];
                j++;
            }
        }
        if (contact.contactNum > 0) {
            for (int i = 0; i < contact.contactNum; i++) {
                pimEntities[j - 1] = "Item " + j + ":" + contact.contactString[i];
                j++;
            }
        }
        if (appointment.appointmentNum > 0) {
            for (int i = 0; i < appointment.appointmentNum; i++) {
                pimEntities[j - 1] = "Item " + j + ":" + appointment.appointmentString[i];
                j++;
            }
        }
    }

    static void list() {
        System.out.println("There are " + pimNum + " items.");
        if (pimNum > 0) {
            savePim();
            for (int i = 0; i < pimEntities.length; i++){
                if (pimEntities[i] != null)
                    System.out.println(pimEntities[i]);
                else
                    break;
            }
        }
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

    static void save() {
        savePim();
        System.out.println("Items have been saved.");
    }

    static void load() { System.out.println("Waiting for realizing."); }

    static void collection() {
        //test program
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String command = " ";

        System.out.println("Welcome to PIM.");
        for(;;) {
            if (command.equals("Quit")) break;
            System.out.println("---Enter a command (suported commands are List Create Save Load Collection Quit)---");
            command = s.nextLine();
            switch(command) {
                case "List": list(); break;
                case "Create": create(); break;
                case "Save": save(); break;
                case "Load": load(); break;
                case "Quit": System.out.println("Thank you for using!"); break;
                case "Collection": collection(); break;
                default: System.out.println("Command Not Find!"); break;
            }
        }
    }
}
