package controller.nhankhau;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.hokhau.QuanLyHoKhau;
import view.nhankhau.ThemNhanKhau;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static model.DatabaseConnector.insertNhanKhau;

public class ThemNhanKhauController  {
    private static ThemNhanKhau themNhanKhauView;

    public ThemNhanKhauController(ThemNhanKhau themNhanKhauview) {
        this.themNhanKhauView = themNhanKhauview;

        // Gắn sự kiện cho nút Thêm
        themNhanKhauView.getBtn_TNK_Yes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThemButtonClick();
            }
        });

        // Gắn sự kiện cho nút Hủy
        themNhanKhauView.getBtn_TNK_No().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHuyButtonClick();
            }
        });

        // Gắn sự kiện cho nút Chọn file
        themNhanKhauView.getBtn_TNK_NhapFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChonFileButtonClick();
            }
        });

    }
    private void handleThemButtonClick() {
        int check = themNhanKhauView.getData();
        if (check == 0) {
            return;
        }
        int confirmResult = JOptionPane.showConfirmDialog(themNhanKhauView.getMainFrame(),
                "Bạn có chắc chắn muốn thêm không?", "Xác nhận thêm ",
                JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // Thực hiện thay đổi ở đây
            if (check == 1) {
                JOptionPane.showMessageDialog(themNhanKhauView.getMainFrame(), "Thêm thành công!");
            } else if (check == -1) {
                JOptionPane.showMessageDialog(themNhanKhauView.getMainFrame(), "Thêm thất bại! Kiểm tra lại thông tin!");
            }
        } else if (confirmResult == JOptionPane.NO_OPTION) {
            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
            JOptionPane.showMessageDialog(themNhanKhauView.getMainFrame(), "Đã hủy thêm.");
        }

    }
    private void handleHuyButtonClick() {
        // Chuyển đến trang Quản lý hộ khẩu
        QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
        themNhanKhauView.getMainFrame().switchToMainPanel(quanLyHoKhauPanel);
    }
    private void handleChonFileButtonClick() {
        openExcelFile();
    }

    private static void openExcelFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Người dùng đã chọn một tệp
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            String fileName = fileChooser.getSelectedFile().getName();
            themNhanKhauView.getLblTenFileDaChon().setText(fileName);

            boolean success = readExcelFile(filePath);
            if (success) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!");
            }
        }
    }
    private static boolean readExcelFile(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            // Tạo Workbook instance cho xlsx file
            Workbook workbook = new XSSFWorkbook(file);
            // Lấy sheet đầu tiên từ workbook
            Sheet sheet = workbook.getSheetAt(0);
            // Lặp qua mỗi hàng (row) của sheet
            for (Row row : sheet) {
                if (row.getRowNum() == 0 || isRowEmpty(row)) {
                    continue; // Bỏ qua dòng trống
                }

                // Đọc dữ liệu từ mỗi cột

                Cell cell = row.getCell(4); // Lấy ô Excel từ cột 2
                // Xử lý ô Excel kiểu số nguyên
                double numericValue = cell.getNumericCellValue();
                int soCMNDCCCD1 = (int) numericValue; // Chuyển đổi thành số nguyên nếu cần
                String soCMNDCCCD = String.valueOf(soCMNDCCCD1);

                String hoTen = row.getCell(1).getStringCellValue(); // Họ Tên
                Date ngaySinhDate = row.getCell(2).getDateCellValue(); // Ngày Sinh
                String tonGiao = row.getCell(3).getStringCellValue(); // Tôn Giáo
                String queQuan = row.getCell(5).getStringCellValue(); // Quê Quán
                String gioiTinh = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "";
                String maHoKhau = row.getCell(7).getStringCellValue(); // Mã Hộ Khẩu

                // Định dạng ngày tháng năm
                String ngaySinh = ngaySinhDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(ngaySinhDate) : "";

                // Xử lý thêm nhân khẩu vào cơ sở dữ liệu
                insertNhanKhau(hoTen, ngaySinh, tonGiao, soCMNDCCCD, queQuan, gioiTinh, maHoKhau);
            }
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private static boolean isRowEmpty(Row row) {
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
}

