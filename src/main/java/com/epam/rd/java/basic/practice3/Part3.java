package com.epam.rd.java.basic.practice3;

public class Part3 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part3.txt";

    public static void main(String[] args) {
        String text = Util.getInput(FILE_PATH);
        System.out.println(convert(text));
    }

    public static String convert(String input) {
        StringBuilder result = new StringBuilder();
        String[] sentence = input.split("\r\n");
        for (String str : sentence) {
            String[] words = str.split(" ");
            result.append("\n");
            for (String word : words) {
                if (word.length() >= 3) {
                    if (Character.isUpperCase(word.charAt(0))) {
                        result.append(Character.toLowerCase(word.charAt(0)) + word.substring(1)).append(" ");
                    } else {
                        result.append(Character.toUpperCase(word.charAt(0)) + word.substring(1)).append(" ");
                    }
                } else {
                    result.append(word).append(" ");
                }
            }
        }
        return result.toString().trim();
    }
}