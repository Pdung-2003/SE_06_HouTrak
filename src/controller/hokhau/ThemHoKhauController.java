package controller.hokhau;

import model.DatabaseConnector;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.hokhau.QuanLyHoKhau;
import view.hokhau.ThemHoKhau;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static model.DatabaseConnector.insertChuHo;
import static model.DatabaseConnector.insertHoKhau;

public class ThemHoKhauController {
    private ThemHoKhau themHoKhauView;

    public ThemHoKhauController(ThemHoKhau themHoKhauView) {
        this.themHoKhauView = themHoKhauView;

        // Gắn sự kiện cho nút Thêm
        themHoKhauView.getBtn_THK_Yes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleThemButtonClick();
            }
        });

        // Gắn sự kiện cho nút Hủy
        themHoKhauView.getBtn_THK_No().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHuyButtonClick();
            }
        });

        // Gắn sự kiện cho nút Chọn file
        themHoKhauView.getBtn_THK_NhapFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChonFileButtonClick();
            }
        });
    }

    private void handleThemButtonClick() {
        int check = themHoKhauView.getData();
        if (check == 0) {
            return;
        }
        int confirmResult = JOptionPane.showConfirmDialog(themHoKhauView.getMainFrame(),
                "Bạn có chắc chắn muốn thêm không?", "Xác nhận thêm ",
                JOptionPane.YES_NO_OPTION);

        if (confirmResult == JOptionPane.YES_OPTION) {
            // Thực hiện thay đổi ở đây
            if (check == 1) {
                JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Thêm thành công!");
            } else if (check == -1) {
                JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Thêm thất bại! Kiểm tra lại thông tin!");
            }
        } else if (confirmResult == JOptionPane.NO_OPTION) {
            // Người dùng chọn "No", không làm gì cả hoặc hiển thị thông báo phù hợp
            JOptionPane.showMessageDialog(themHoKhauView.getMainFrame(), "Đã hủy thêm.");
        }
    }

    private void handleHuyButtonClick() {
        // Chuyển đến trang Quản lý hộ khẩu
        QuanLyHoKhau quanLyHoKhauPanel = new QuanLyHoKhau();
        themHoKhauView.getMainFrame().switchToMainPanel(quanLyHoKhauPanel);
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
            System.out.println("Selected file: " + filePath);
            readExcelFile(filePath);
        }
    }
    private static void readExcelFile(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            // Tạo Workbook instance cho xlsx file
            Workbook workbook = new XSSFWorkbook(file);
            // Lấy sheet đầu tiên từ workbook
            Sheet sheet = workbook.getSheetAt(0);
            // Lặp qua mỗi hàng (row) của sheet
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Bỏ qua tiêu đề

                // Đọc dữ liệu từ mỗi cột
                String hoTenChuHo = row.getCell(1).getStringCellValue();
                Cell cell = row.getCell(2); // Lấy ô Excel từ cột 2
                // Xử lý ô Excel kiểu số nguyên
                double numericValue = cell.getNumericCellValue();
                int soCMNDCCCD1 = (int) numericValue; // Chuyển đổi thành số nguyên nếu cần
                String soCMNDCCCD = String.valueOf(soCMNDCCCD1);
                String gioiTinh = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "";
                Date ngaySinhDate = row.getCell(4) != null ? new Date(row.getCell(4).getDateCellValue().getTime()) : null;
                String tonGiao = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "";
                String queQuan = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "";
                String diaChi = row.getCell(7).getStringCellValue();
                String khuVuc = row.getCell(8).getStringCellValue();

                // Chèn vào cơ sở dữ liệu
                insertHoKhau(hoTenChuHo, diaChi, khuVuc); // Hàm này cần được cập nhật để chấp nhận các tham số mới
                insertChuHo(hoTenChuHo, ngaySinhDate, tonGiao, soCMNDCCCD, queQuan, gioiTinh, diaChi);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
