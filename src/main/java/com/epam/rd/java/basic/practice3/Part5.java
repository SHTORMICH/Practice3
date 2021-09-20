package com.epam.rd.java.basic.practice3;

public class Part5 {
    private static final String[] ROMANS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] DECIMAL = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    private static final String SEPARATOR = " --> ";

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            String builder = i + SEPARATOR + decimal2Roman(i) + SEPARATOR + roman2Decimal(decimal2Roman(i));
            System.out.println(builder);
        }
    }

    public static String decimal2Roman(int dec) {
        StringBuilder result = new StringBuilder();
        int count;
        for (int i = DECIMAL.length - 1; i >= 0 ; i--) {
            count = dec / DECIMAL[i];
            dec %= DECIMAL[i];
            while (count > 0) {
                result.append(ROMANS[i]);
                count--;
            }
        }
        return result.toString();
    }

    public static int roman2Decimal(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int decimalNub1 = value(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int decimalNub2 = value(roman.charAt(i + 1));
                if (decimalNub1 >= decimalNub2) {
                    result += decimalNub1;
                } else {
                    result += decimalNub2 - decimalNub1;
                    i++;
                }
            } else {
                result += decimalNub1;
            }
        }
        return result;
    }

    static int value(char r) {
        switch (r) {
            case 'I' :
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            default: return -1;
        }
    }
}
