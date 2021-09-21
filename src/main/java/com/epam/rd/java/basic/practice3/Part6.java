package com.epam.rd.java.basic.practice3;

public class Part6 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part6.txt";

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);
        System.out.println(convert(text));
    }

    public static String convert(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split(System.lineSeparator());
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                result.append(word).append(" ");
            }
        }
        String[] wordsArr = result.toString().split(" ");
        result = new StringBuilder();
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                int count = -1;
                for (String checkWord : wordsArr) {
                    if (word.equals(checkWord)) {
                        count++;
                    }
                }
                if (count == 0) {
                    result.append(" ").append(word);
                } else {
                    result.append(" _").append(word);
                }
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }
}
