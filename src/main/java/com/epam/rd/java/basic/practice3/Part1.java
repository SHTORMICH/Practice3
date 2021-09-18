package com.epam.rd.java.basic.practice3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Part1 {

    public static void main(String[] args) {
        StringBuilder textInFile = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("part1.txt"))) {
            bufferedReader.readLine();
            String value = bufferedReader.readLine();
            while (value != null) {
                textInFile.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String text = textInFile.toString();

        System.out.println(text);

        System.out.println("Convert 1");
        System.out.println(convert1(text));
        System.out.println("Convert 2"); // у тебя тут перенос строки до
        System.out.println(convert2(text));
        System.out.println("Convert 3");
        System.out.println(convert3(text));
        System.out.println("\nConvert 4");
        System.out.println(convert4(text));
    }

    public static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\n");
        for (String str : sentence) {
            String[] words = str.split(";");
            result.append(words[0]).append(": ").append(words[2]).append("\n");
        }
        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        for (String str : sentence) {
            String[] words = str.split(";");
            result.append(words[1]).append(" (email: ").append(words[2]).append(")\n");
        }
        return result.toString();
    }

    public static String convert3(String input) {
        StringBuilder resultMail = new StringBuilder();
        StringBuilder resultGog = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        for (String str : sentence) {
            String[] words = str.split(";");
            String word = words[2].split("@")[1];
            if (word.equals("mail.com")) {
                resultMail.append(words[0]).append(", ");
            } else {
                resultGog.append(words[0]).append(", ");
            }
        }
        result.append("mail.com ==> ")
                .append(resultMail.substring(0, resultMail.length() - 2))
                .append("\n")
                .append("google.com ==> ")
                .append(resultGog.substring(0, resultGog.length() - 2));
        return result.toString();
    }

    public static String convert4(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        Random random = new Random();
        for (String str : sentence) {
            result.append(str).append(";").append(random.nextInt(9000) + 1000).append("\n");
        }
        return result.toString();
    }
}
