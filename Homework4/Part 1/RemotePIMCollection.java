import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public interface RemotePIMCollection {
    ArrayList getTodos() throws IOException;

    ArrayList getAppointments() throws IOException;

    ArrayList getItemsForDate(String data) throws IOException;
}
