/**
 * @author gaohaishuo
 * @version 1.0
 * Program entry.
 * If no args,Run with the date "2016.5".
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	int month, year;
    	try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch( Exception e ) {
            System.out.println("Wrong Date Input! Use default: 2016.5");
            month = 5;
            year = 2016;
        }
        PIM pim = new PIM(year,month);
        pim.run();
    }
}
