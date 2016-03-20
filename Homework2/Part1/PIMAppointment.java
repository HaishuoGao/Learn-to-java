// Appointment items must be PIMEntites defined in a class named PIMAppointment. 
// Each appointment must have a priority (a string), 
// a date and a description (a string).

public class PIMAppointment extends PIMEntity implements Data {
    String description;
    String appointmentData = "03/25/2013";

    public void setData(String s) {
        appointmentData = s;
    }

    public void fromString(String s) {
        description = s;
    }

    public String toString() {
        return "APPOINTMENT: " + Priority +" " + description +" " + appointmentData;
    }
}


