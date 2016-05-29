import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * @author gaohaishuo
 * @version 1.0
 * Main program.
 */

public class PIM {
    /**
     * Define three int: year, month, nextday.
     * Year and month is initialized by 2016.5.
     */
    int year = 2016, month = 5, nextday;

    /**
     * Name is an array for table header.
     * Calendar is a double dimensional array for table.
     */
    Object[] name = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    Object[][] calcendar;

    /**
     * Instant a class named pimCollection.
     */
    RemoteCollection pimCollection;

    /**
     * Two file paths for the button icons.
     */
    String lastButtonPath = "last.jpg";
    String nextButtonPath = "next.jpg";

    /**
     * Define a frame and the menu bar.
     */
    JFrame frame = new JFrame("Personal Information Manager");
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu viewMenu = new Menu("View");
    Menu editMenu = new Menu("Edit");
    Menu createMenu = new Menu("Create");
    MenuItem saveItem = new MenuItem("Save");
    MenuItem loadItem = new MenuItem("Load");
    MenuItem createTODO = new MenuItem("New Todo");
    MenuItem createNOTE = new MenuItem("New Note");
    MenuItem createAPPOINTMENT = new MenuItem("New Appointment");
    MenuItem createCONTACT = new MenuItem("New Contact");
    MenuItem viewTODO = new MenuItem("View Todo");
    MenuItem viewNOTE = new MenuItem("View Note");
    MenuItem viewAPPOINTMENT = new MenuItem("View Appointment");
    MenuItem viewCONTACT = new MenuItem("View Contact");
    MenuItem editTODO = new MenuItem("Edit Todo");
    MenuItem editNOTE = new MenuItem("Edit Note");
    MenuItem editAPPOINTMENT = new MenuItem("Edit Appointment");
    MenuItem editCONTACT = new MenuItem("Edit Contact");

    /**
     * Define container, a label and a table.
     */
    Container container = frame.getContentPane();
    JLabel titleLable = new JLabel();
    JTable calcendarTable;

    /**
     * Add the icon to the button.
     */
    ImageIcon lastButton = new ImageIcon(lastButtonPath);
    ImageIcon nextButton = new ImageIcon(nextButtonPath);
    JButton buttonToChangeToLastMonth = new JButton(lastButton);
    JButton buttonToChangeToNextMonth = new JButton(nextButton);

    /**
     * Init.
     * @param yearFromInput
     * @param monthFromInput
     */
    PIM(int yearFromInput, int monthFromInput) {
        year = yearFromInput;
        month = monthFromInput;
        String userName = JOptionPane.showInputDialog("Please input your name:");
        pimCollection = new RemoteCollection(userName);
    }

    /**
     * This function is to define the actions.
     * @throws IOException
     */
    void run() throws IOException {
        /**
         * Add items to the frame.
         */
        frame.setMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(createMenu);
        menuBar.add(viewMenu);
        menuBar.add(editMenu);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        createMenu.add(createTODO);
        createMenu.add(createAPPOINTMENT);
        createMenu.add(createCONTACT);
        createMenu.add(createNOTE);

        viewMenu.add(viewAPPOINTMENT);
        viewMenu.add(viewCONTACT);
        viewMenu.add(viewNOTE);
        viewMenu.add(viewTODO);

        editMenu.add(editAPPOINTMENT);
        editMenu.add(editCONTACT);
        editMenu.add(editNOTE);
        editMenu.add(editTODO);

        /**
         * Add action to each button.
         */
        editTODO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.editTodo();
                    pimManager.save();
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        editAPPOINTMENT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.editAppointment();
                    pimManager.save();
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        editCONTACT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.editContact();
                    pimManager.save();
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        editNOTE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.editNote();
                    pimManager.save();
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimManager.save();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimCollection.filePath = pimManager.load();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });

        createTODO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimManager.create("TODO");
                pimManager.save();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        createAPPOINTMENT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimManager.create("APPOINTMENT");
                pimManager.save();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        createCONTACT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimManager.create("CONTACT");
                pimManager.save();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });
        createNOTE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                pimManager.create("NOTE");
                pimManager.save();
                try {
                    calcendar = getCalcendar();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                drawTheFrame();
            }
        });

        viewAPPOINTMENT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.viewAppointment();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        viewCONTACT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.viewContact();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        viewNOTE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.viewNote();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        viewTODO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PIMManager pimManager = new PIMManager();
                try {
                    pimManager.viewTodo();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        container.setLayout(new BorderLayout());

        buttonToChangeToLastMonth.setPreferredSize(new Dimension(50,460));
        buttonToChangeToNextMonth.setPreferredSize(new Dimension(50,460));
        buttonToChangeToLastMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month > 1) {
                    month -= 1;
                }
                else {
                    year -= 1;
                    month = 12;
                }

                try {
                    calcendar = getCalcendar();
                    frame.remove(titleLable);
                    drawTheFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttonToChangeToNextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month < 12) {
                    month += 1;
                }
                else {
                    year += 1;
                    month = 1;
                }
                try {
                    calcendar = getCalcendar();
                    frame.remove(titleLable);
                    drawTheFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        container.add(buttonToChangeToLastMonth, BorderLayout.BEFORE_LINE_BEGINS);
        container.add(buttonToChangeToNextMonth, BorderLayout.AFTER_LINE_ENDS);

        calcendar = getCalcendar();
        drawTheFrame();
    }

    /**
     * This function is to draw the GUI.
     */
    void drawTheFrame() {
        titleLable = new JLabel(year + "年" + month + "月",JLabel.CENTER);

        container.add(titleLable, BorderLayout.PAGE_START);
        calcendarTable = new JTable(calcendar, name);
        calcendarTable.setGridColor(Color.white);
        calcendarTable.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer());
        calcendarTable.getTableHeader().setResizingAllowed(false);

        container.add(new JScrollPane(calcendarTable));

        frame.setSize(960,480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Input an arraylist,output a String.
     * @param arrayList
     * @return a string.
     */
    public String arrayListToString(ArrayList<String> arrayList) {
        String string = new String();
        for (int i = 0; i < arrayList.size(); i++) {
            string = string.concat(arrayList.get(i));
        }
        return string;
    }

    /**
     * Get calendar.
     * @return the month with double dimensional array.
     * @throws IOException
     */
    String[][] getCalcendar() throws IOException {

        String tempTable[][] = new String[6][7];
        String result[][] = new String[5][7];
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        /**
         * Decide days of the month.
         */
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

        /**
         * Put the month in a double dimensional array.
         */
        nextday = 1;
        for (int k = 0; k < 6; k++) {
            if (k == 0) {
                for (int j = weekDay; j < 7; j++) {
                    String data = month + "/" + nextday + "/" + year;
                    ArrayList<String> itemForData = pimCollection.getItemsForDate(data);
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
                    ArrayList<String> itemForData = pimCollection.getItemsForDate(data);
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

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                result[i][j] = tempTable[i][j];
            }
        }
        return result;
    }
}
