/**
 * @author gaohaishuo
 * @version 1.0
 * Interface RemotePIMCollection.
 */

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author GaoHaishuo
 */
public interface RemotePIMCollection {
    /**
     * Get todos from a string or a file.
     * @return
     * @throws IOException
     */
    ArrayList getTodos() throws IOException;

    /**
     * Get appointments from a string or a file.
     * @return
     * @throws IOException
     */
    ArrayList getAppointments() throws IOException;

    /**
     * Get todos and appointments from a string or a file.
     * @param data
     * @return
     * @throws IOException
     */
    ArrayList getItemsForDate(String data) throws IOException;

    /**
     * Get notes from a string or a file.
     * @return
     * @throws IOException
     */
    ArrayList getNotes() throws IOException;

    /**
     * Get contacts from a string or a file.
     * @return
     * @throws IOException
     */
    ArrayList getContacts() throws IOException;

}
