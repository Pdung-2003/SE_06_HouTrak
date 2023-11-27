package view.hokhau;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomRowHeightRenderer extends DefaultTableCellRenderer {
    private int rowHeight;

    public CustomRowHeightRenderer(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Đặt kích thước của từng dòng
        table.setRowHeight(row, rowHeight);

        return renderer;
    }
}