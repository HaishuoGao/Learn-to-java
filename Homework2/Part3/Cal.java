import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Cal {
    static final String[] monthStr = { "January",
                     "February",
                     "March",
                     "April",
                     "May",
                     "June",
                     "July",
                     "August",
                     "September",
                     "October",
                     "November",
                     "December"};

    private static int getDataCount(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int count = cal.getActualMaximum(Calendar.DATE);
        return count;
    }

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int month, year;
        try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch( Exception e ) {
            month = cal.get(Calendar.MONTH);
            year = cal.get(Calendar.YEAR);
            month++;
        }
        int count = getDataCount(year, month);
        cal.setTime(sdf.parse(year + "-" + month + "-" + 1));
        int first = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(monthStr[month - 1] + " " + year);
        System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");
        for (int i = 1; i < first; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= count; i++) {
            System.out.print(i + "\t");
            cal.setTime(sdf.parse(year + "-" + month + "-" + i));
            if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}