package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originArray = origin.split("[.,!:;? ]");
        String[] lineArray = line.split("[.,!:;? ]");
        Set<String> hashSet = new HashSet<>();
        for (String value : originArray) {
            hashSet.add(value);
        }
        for (String value : lineArray) {
            if (!hashSet.contains(value)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}