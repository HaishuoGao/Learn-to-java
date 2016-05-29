/**
 * @author gaohaishuo
 * @version 1.0
 * About GUI table cell.
 */

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer {
    public TableCellTextAreaRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setBackground(new Color(220,220,220));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int maxPreferredHeight = 84;
        
        if (table.getRowHeight(row) != maxPreferredHeight) 
            table.setRowHeight(maxPreferredHeight);

        setText(value == null ? "" : value.toString());
        return this;
    }
}