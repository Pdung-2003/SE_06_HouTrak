package test;

import javax.swing.UIManager;

import view.LoginView;
import view.ManHinhChinh;
import view.SignIn;
import view.ThemHoKhau;

public class TestAll {
    public static void main(String[] args) {
        try {
            new SignIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
