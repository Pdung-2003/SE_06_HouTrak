package test;

import javax.swing.UIManager;

import view.*;

public class Test {
    public static void main(String[] args) {
        try {
            new LoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
