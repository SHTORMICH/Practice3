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

    public static String convert3(String input) {
        String[] lines = input.split("\r\n");
        StringBuilder domains = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            String mailInLine = lines[i].substring(lines[i].indexOf("@") + 1);
            if (!domains.toString().contains(mailInLine)) {
                domains.append(mailInLine).append(" ");
            }
        }
        String[] domainsSplit = domains.toString().split(" ");
        for (String domain: domainsSplit) {
            StringBuilder domainsLine = new StringBuilder();

            domainsLine.append(domain).append(" ==> ");
            for (int i = 1; i < lines.length; i++) {
                String[] words = lines[i].split(";");
                if (words[2].substring(words[2].indexOf("@") + 1).equals(domain)) {
                    domainsLine.append(words[0]).append(", ");
                }
            }
            String filterLine = domainsLine.toString().replaceAll(", $", "");
            result.append(filterLine).append(System.lineSeparator());
        }
        return result.toString();
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
