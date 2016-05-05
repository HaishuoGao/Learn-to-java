import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Calcendar implements RemotePIMCollection {
    int year = 2016, month = 5, nextday;
    String filePath = "PIMEntity.data";

    JFrame frame = new JFrame("Calcendar");
    Container container = frame.getContentPane();
    JLabel titleLable = new JLabel("2016年4月");

    Object[] name = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    Object[][] calcendar;
    JTable calcendarTable;

    Calcendar(int yearFromInput, int monthFromInput) throws IOException {
        year = yearFromInput;
        month = monthFromInput;
        container.setLayout(new BorderLayout());

        container.add(titleLable, BorderLayout.BEFORE_FIRST_LINE);

        calcendar = getCalcendar();

        calcendarTable = new JTable(calcendar, name);
        calcendarTable.setGridColor(Color.white);
        calcendarTable.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
        calcendarTable.getTableHeader().setResizingAllowed(false);

        container.add(new JScrollPane(calcendarTable));

        frame.setSize(640,480);
        frame.setVisible(true);
    }

    String arrayListToString(ArrayList<String> arrayList) {
        String string = new String();
        for (int i = 0; i < arrayList.size(); i++) {
            string = string.concat(arrayList.get(i));
        }
        return string;
    }

    String[][] getCalcendar() throws IOException {
        String tempTable[][] = new String[5][7];
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int day = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        }
        if (month == 2) {
            if (((year % 4 == 0) && (year % 100 != 0)) || ( year % 400 == 0)) {
                day = 29;
            }
            else {
                day = 28;
            }
        }

        nextday = 1;
        for (int k = 0; k < 6; k++) {
            if (k == 0) {
                for (int j = weekDay; j < 7; j++) {
                    String data = month + "/" + nextday + "/" + year;
                    ArrayList<String> itemForData = getItemsForDate(data);
                    if (!itemForData.isEmpty()) {
                        tempTable[k][j] = "" + nextday + "\n" + arrayListToString(itemForData); 
                    }
                    else {
                        tempTable[k][j] = "" + nextday; 
                    }
                    nextday++;
                }
            }
            else {
                for (int j = 0; j < 7 && nextday <= day; j++) {
                    String data = month + "/" + nextday + "/" + year;
                    ArrayList<String> itemForData = getItemsForDate(data);
                    if (!itemForData.isEmpty()) {
                        tempTable[k][j] = "" + nextday + "\n" + arrayListToString(itemForData); 
                    }
                    else {
                        tempTable[k][j] = "" + nextday; 
                    }
                    nextday++;
                }
            }
        }

        return tempTable;
    }

    String ReadFromeFile(String filePath) {
        FileReader reader;
        String result = null;
        try {
            reader = new FileReader(filePath);
            char[] buf = new char[1024];
            int temp = reader.read(buf);
            result = new String(buf,0,temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    String[] fileStringByLine = ReadFromeFile(filePath).split("\n");

    @Override
    public ArrayList<String> getTodos() throws IOException {
        ArrayList<String> todoDate = new ArrayList<>();
        ArrayList<String> todoContent = new ArrayList<>();
        ArrayList<String> todoPriority = new ArrayList<>();
        ArrayList<String> todos = new ArrayList<>();
        int todoNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("TODO")) {
                todoDate.add(fileStringByLine[i + 1]);
                todoContent.add(fileStringByLine[i + 2]);
                todoPriority.add(fileStringByLine[i + 3]);
                todoNum += 1;
            }
        }

        for (int i = 0; i < todoNum; i++) {
            todos.add(todoDate.get(i) + "\n" + todoContent.get(i) + "\n" + todoPriority.get(i) + "\n");
        }

        return todos;
    }

    @Override
    public ArrayList<String> getAppointments() throws IOException {
        ArrayList<String> appointmentDate = new ArrayList<>();
        ArrayList<String> appointmentDescript = new ArrayList<>();
        ArrayList<String> appointmentPriority = new ArrayList<>();
        ArrayList<String> appointments = new ArrayList<>();
        int todoNum = 0;

        for (int i = 0; i < fileStringByLine.length; i++) {
            if (fileStringByLine[i].contains("APPOINTMENT")) {
                appointmentDate.add(fileStringByLine[i + 1]);
                appointmentDescript.add(fileStringByLine[i + 2]);
                appointmentPriority.add(fileStringByLine[i + 3]);
                todoNum += 1;
            }
        }

        for (int i = 0; i < todoNum; i++) {
            appointments.add(appointmentDate.get(i) + "\n" + appointmentDescript.get(i) + "\n" + appointmentPriority.get(i) + "\n");
        }

        return appointments;
    }

    @Override
    public ArrayList<String> getItemsForDate(String data) throws IOException {
        ArrayList<String> todos = getTodos();
        ArrayList<String> appointments = getAppointments();
        ArrayList<String> itemsForData = new ArrayList<>();

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).toString().contains(data)) {
                String[] temp = todos.get(i).toString().split("\n");
                itemsForData.add(temp[1] + "\n" + temp[2]);
            }
        }

        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).toString().contains(data)) {
                String[] temp = appointments.get(i).toString().split("\n");
                itemsForData.add(temp[1] + "\n" + temp[2]);
            }
        }

        return itemsForData;
    }

}
