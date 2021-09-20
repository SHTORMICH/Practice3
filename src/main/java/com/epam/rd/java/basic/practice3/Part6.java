package com.epam.rd.java.basic.practice3;

public class Part6 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part6.txt";

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);
        System.out.println(convert(text));
    }

    //Не коректно выводится
    public static String convert(String input) {
        String firstWord = input.substring(0, input.indexOf(' '));
        StringBuilder result = new StringBuilder();
        result.append(firstWord);
        String[] lines = input.split("\r\n");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (int i = 1; i < words.length; i++) {
                result.append(" _").append(words[i]);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
