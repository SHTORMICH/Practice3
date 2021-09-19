package com.epam.rd.java.basic.practice3;

import java.util.Random;

public class Part1 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part1.txt";

    public static void main(String[] args) {
        String text = Util.getInput(FILE_PATH);

        System.out.println("Convert 1");
        System.out.println(convert1(text));
        System.out.println("Convert 2");
        System.out.println(convert2(text));
        System.out.println("Convert 3");
        System.out.println(convert3(text));
        System.out.println("\nConvert 4");
        System.out.println(convert4(text));
    }

    public static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\n");
        for (int i = 1; i < sentence.length; i++) {
            String[] words = sentence[i].split(";");
            result.append(words[0]).append(": ").append(words[2]).append("\n");
        }
        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        for (int i = 1; i < sentence.length; i++) {
            String[] words = sentence[i].split(";");
            result.append(words[1])
                    .append(" (email: ")
                    .append(words[2])
                    .append(")")
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
    // Некоректно работает convert3
    public static String convert3(String input) {
        String[] lines = input.split("\r\n");
        StringBuilder mails = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String mailInLine = lines[i].substring(lines[i].indexOf("@") + 1);
            if (!mails.toString().contains(mailInLine)) {
                mails.append(mailInLine).append(" ");
            }
        }
        mails.toString().split(" ");
        for (int i = 1; i < lines.length; i++) {
            String[] words = lines[i].split(";");
            for (String word : words) {
                if (word.substring(word.indexOf("@") + 1))
            }
        }
        return mails.toString();
    }

    public static String convert4(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        Random random = new Random();
        for (int i = 1; i < sentence.length; i++) {
            result.append(sentence[i]).append(";").append(random.nextInt(9000) + 1000).append(System.lineSeparator());
        }
        return result.toString();
    }
}
