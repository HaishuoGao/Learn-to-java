/**
 * @author gaohaishuo
 * @version 1.0
 * Abstract class implemented by PIMTodo,PIMContact,PIMNote and PIMAppointment .
 */

public abstract class PIMEntity {
    /**
     * Every kind of item has a priority.
     */
    String Priority;

    /**
     * Default constructor sets priority to "normal".
     */
    PIMEntity() {
        Priority = "normal";
    }

    /**
     * Priority can be established via this constructor.
     * Accessor method for getting the priority string.
     * @return
     */
    public String getPriority() {
        return Priority;
    }

    /**
     * Method that changes the priority string.
     * @param p
     */
    public void setPriority(String p) {
        Priority = p;
    }

    /**
     * Each PIMEntity needs to be able to set all state information (fields) from a single text string.
     * @return
     */
    abstract public String toString();
}