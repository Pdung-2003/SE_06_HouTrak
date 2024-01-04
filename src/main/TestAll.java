package main;

import view.dangnhap.ManHinhChinh;
import view.dangnhap.SignIn;

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

