// Appointment items must be PIMEntites defined in a class named PIMAppointment. 
// Each appointment must have a priority (a string), 
// a date and a description (a string).

public class PIMAppointment implements PIMEntity, Data {
    String description;
    String appointmentData = "03/25/2013";
    String Priority; // every kind of item has a priority

    public void PIMEntity() {
        Priority = "normal";
    }

    // priority can be established via this constructor.
    public void PIMEntity(String priority) {
        Priority =  priority;
    }

    // accessor method for getting the priority string
    public String getPriority() {
        return Priority;
    }
    // method that changes the priority string
    public void setPriority(String p) {
        Priority = p;
    }

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


