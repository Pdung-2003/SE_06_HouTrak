package test;

import javax.swing.UIManager;

import view.LoginView;
import view.ManHinhChinh;
import view.ThemHoKhau;

public class Test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new ManHinhChinh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
