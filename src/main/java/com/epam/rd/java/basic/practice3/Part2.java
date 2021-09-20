package com.epam.rd.java.basic.practice3;

public class Part2 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part2.txt";

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);
        System.out.println(convert(text));

    }

    public static String convert(String input) {
        StringBuilder minWords = new StringBuilder();
        StringBuilder maxWords = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\r\n");
        int minLength = getMinAndMaxLength(lines)[0];
        int maxLength = getMinAndMaxLength(lines)[1];

        for (String line : lines) {
            String[] words = line.split("\\W");

            for (String word : words) {

                if (minLength == word.length()) {
                    minWords.append(word).append(" ");
                }
                if (maxLength == word.length()) {
                    maxWords.append(word).append(" ");
                }
            }
        }

        String minResult = removeDuplicatesMax(minWords.toString());
        String maxResult = removeDuplicatesMax(maxWords.toString());

        if (minResult.length() > 0 && maxResult.length() > 0) {
            result.append("Min: ").append(minResult, 0, minResult.length() - 2).append("\n")
                    .append("Max: ").append(maxResult, 0, maxResult.length() - 2);
        } else {
            result.append("Min: ").append("\n")
                    .append("Max: ");
        }
        return result.toString();
    }

    public static int[] getMinAndMaxLength(String[] lines) {
        String minWord = lines[0].substring(0, lines[0].indexOf(' '));
        String maxWord = lines[0].substring(0, lines[0].indexOf(' '));
        int[] minAndMax = new int[2];
        int minLength = minWord.length();
        int maxLength = maxWord.length();

        for (String line : lines) {
            String[] words = line.split("\\W");

            for (String word : words) {

                if (minWord.length() > word.length() && word.length() > 0) {
                    minWord = word;
                    minLength = word.length();
                }
                if (maxWord.length() < word.length()) {
                    maxWord = word;
                    maxLength = word.length();
                }
            }
        }
        minAndMax[0] = minLength;
        minAndMax[1] = maxLength;
        return minAndMax;
    }

    public static String removeDuplicatesMax(String input){
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(!result.toString().contains(words[i])) {
                result.append(words[i]).append(", ");
            }
        }
        return result.toString();
    }
}
