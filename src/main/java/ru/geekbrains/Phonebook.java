package ru.geekbrains;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private static int num = 0;
    HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();

    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        book.add("Семенов", "8(955)312-67-28");
        book.add("Зеленский", "1(3682)415-28-18");
        book.add("Ельцин", "9(111)410-20-20");
        book.add("Горбачев", "8(955)131-38-64");
        book.add("Семенов", "8(513)513-58-11");

        for (String x : book.get("Семенов")) {
            num++;
            System.out.println("Семенов " + num + " телефон: " + x);
        }
    }


    private void add(String surname, String phonenumber) {
        ArrayList<String> strings = phoneMap.get(surname);
        System.out.println("String = " + strings);

        if (strings == null) {
            ArrayList<String> listOfPhones = new ArrayList<>();
            listOfPhones.add(phonenumber);
            phoneMap.put(surname, listOfPhones);
        } else {
            strings.add(phonenumber);
            phoneMap.put(surname, strings);
        }
    }

    public ArrayList<String> get(String surname) {
        return phoneMap.get(surname);
    }
}

