package ru.geekbrains;

import java.util.*;

public class VerbumQuaerere {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays
                .asList("тьма", "объятья", "холод", "лед", "шепот", "лунный", "сладкий ", "мед", "лед", "объятья",
                        "лед", "тепла", "греет", "спящих", "мертвых", "тьма"));
        somestrangeWords(words);

    }

    private static void somestrangeWords(ArrayList<String> words) {
        HashSet<String> somestrangeWords = new HashSet<>(words);
        Map<String, Integer> countWord = new HashMap<>();
        int count = 0;
        for (String word : somestrangeWords) {
            for (String allWord : words) {
                if (word.equals(allWord)) {
                    count++;
                }
            }
            if (count == 0) {
                count++;
            }
            countWord.put(word, count);
            count = 0;
        }
        System.out.println("Эти слова выделяются из общего массива: " + somestrangeWords);
        for (Map.Entry<String, Integer> e : countWord.entrySet()) {
            System.out.printf("Эти слова встречаются %s - %d.\n", e.getKey(), e.getValue());
        }
    }
    }



