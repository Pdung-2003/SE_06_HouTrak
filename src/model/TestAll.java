package model;

import view.dangnhap.ManHinhChinh;

public class TestAll {
    public static void main(String[] args) {
        try {
            //new SignIn();
            new ManHinhChinh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
