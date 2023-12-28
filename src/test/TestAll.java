package test;

import view.dangnhap.ManHinhChinh;
import view.dangnhap.SignIn;

public class TestAll {
    public static void main(String[] args) {
        try {
            new SignIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

