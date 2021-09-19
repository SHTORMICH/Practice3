package com.epam.rd.java.basic.practice3;

public class Part2 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part2.txt";

    public static void main(String[] args) {
        String text = Util.getInput(FILE_PATH);
        System.out.println(convert(text));

    }

    public static String convert(String input) {
        String minWord = input.substring(0, input.indexOf(' '));
        String maxWord = input.substring(0, input.indexOf(' '));
        StringBuilder minWords = new StringBuilder();
        StringBuilder maxWords = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\r\n");

        for (String line : lines) {
            String[] words = line.split("\\W");

            for (String word : words) {

                if (minWord.length() >= word.length() && word.length() != 0 && !minWord.equals(word)) {
                    minWord = word;
                    minWords.append(word);
                }
                if (maxWord.length() <= word.length() && !maxWord.equals(word)) {
                    maxWord = word;
                    maxWords.append(word).append(", ");
                }
            }
        }
        String minResult = removeDuplicates(minWords.toString());
        String maxResult = removeDuplicatesMax(maxWords.toString());
        result.append("Min: ").append(minResult.substring(0, minResult.length() - 2)).append("\n")
                .append("Max: ").append(maxResult.substring(0, maxResult.length() - 2));
        return result.toString();
    }

    public static String removeDuplicatesMax(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(input)) {
                result += input;
            }
        }
        return result;
    }
    public static String removeDuplicates(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(String.valueOf(input.charAt(i)))) {
                result += input.charAt(i) + ", ";
            }
        }
        return result;
    }
}
