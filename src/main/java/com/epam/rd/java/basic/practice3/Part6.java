package com.epam.rd.java.basic.practice3;

public class Part6 {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/part6.txt";

    public static void main(String[] args) {
        String text = Util.readFile(FILE_PATH);
        System.out.println(convert(text));
    }

    public static String convert(String input) {
        StringBuilder result = splitter(input);
        String[] lines = input.split(System.lineSeparator());
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
                    if (word.equals(words[words.length - 1])) {
                        result.append(word);
                    } else {
                        result.append(word).append(" ");
                    }
                } else {
                    if (word.equals(words[words.length - 1])) {
                        result.append(word);
                    } else {
                        result.append(word).append(" _");
                    }
                }
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

    public static StringBuilder splitter(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split(System.lineSeparator());
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                result.append(word).append(" ");
            }
        }
        return result;
    }
}
