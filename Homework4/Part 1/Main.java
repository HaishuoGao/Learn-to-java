import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	int month, year;
    	try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch( Exception e ) {
            month = 5;
            year = 2016;
        }
        Calcendar cal = new Calcendar(year,month);
    }
}
