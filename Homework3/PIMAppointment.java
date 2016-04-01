import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PIMAppointment extends PIMEntity implements Data {
    String description;
    String appointmentData = "03/25/2013";
    public int appointmentNum = 0;
    public String[] appointmentString = new String[100];

    public void fromString(String s) { description = s; }

    public String toString() { return "APPOINTMENT " + appointmentData +" " + description +" " + Priority; }

    public void setData(String s) {
        String dataFormat = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Scanner str = new Scanner(System.in);
        Pattern p = Pattern.compile(dataFormat);
        do {
            Matcher m = p.matcher(s);
            boolean dateFlag = m.matches();
            if (dateFlag) break;
            System.out.println("Wrong data format,Please try again:");
            s = str.nextLine();
        } while (true);
        appointmentData = s;
    }

    @Override
    public String setData() {
        return null;
    }

    public void createAppointment() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter date for appointment item(mm/dd/yyyy):");
        setData(s.nextLine());
        System.out.println("Enter appointment description:");
        fromString(s.nextLine());
        System.out.println("Enter appointment priority:");
        String priority = s.nextLine();
        setPriority(priority);
        appointmentString[appointmentNum] = toString();
        appointmentNum++;
    }
}