package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < length; i ++) {
            int rsl = Integer.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        } return left.length() - right.length();
    }
}
