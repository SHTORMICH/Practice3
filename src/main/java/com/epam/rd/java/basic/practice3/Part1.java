package com.epam.rd.java.basic.practice3;

import java.util.Random;

public class Part1 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part1.txt";
    private static final Random random = new Random();

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);

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
        String[] sentence = input.split(System.lineSeparator());
        for (int i = 1; i < sentence.length; i++) {
            String[] words = sentence[i].split(";");
            result.append(words[0]).append(": ").append(words[2]).append("\n");
        }
        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split(System.lineSeparator());
        for (int i = 1; i < sentence.length; i++) {
            String[] words = sentence[i].split(";");
            String[] name = words[1].split(" ");
            result.append(name[1])
                    .append(" ")
                    .append(name[0])
                    .append(" (email: ")
                    .append(words[2])
                    .append(")")
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    public static String convert3(String input) {
        String[] lines = input.split(System.lineSeparator());
        StringBuilder domains = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String mailInLine = lines[i].substring(lines[i].indexOf('@') + 1);
            if (!domains.toString().contains(mailInLine)) {
                domains.append(mailInLine).append(" ");
            }
        }
        String[] domainsSplit = domains.toString().split(" ");
        for (int i = 0; i < domainsSplit.length; i++) {

            StringBuilder domainsLine = new StringBuilder();

            domainsLine.append(domainsSplit[i]).append(" ==> ");

            for (int j = 1; j < lines.length; j++) {
                String[] words = lines[j].split(";");

                if (words[2].substring(words[2].indexOf('@') + 1).equals(domainsSplit[i])) {
                    domainsLine.append(words[0]).append(", ");
                }
            }
            String filterLine = domainsLine.toString().replaceAll(", $", "");
            if (domainsSplit[i].equals(domainsSplit[domainsSplit.length - 1])) {

                result.append(filterLine).append(" ");
            } else  {
                result.append(filterLine).append(" ").append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    public static String convert4(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split(System.lineSeparator());
        int rValue;
        result.append(sentence[0]).append(";Password").append(System.lineSeparator());
        for (int i = 1; i < sentence.length; i++) {
            rValue = random.nextInt(10000);
            result.append(sentence[i]).append(";").append(String.format("%04d", rValue)).append(System.lineSeparator());
        }
        return result.toString();
    }
}
