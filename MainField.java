package ru.geekbrains;

import javax.swing.*;

public class MainField extends JFrame {
    public MainField () {
        setTitle("Whorm");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320, 345);
        setLocation(400,400);
        add(new OpenGame());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainField mf = new MainField();
    }
}
