package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> originList = Arrays.asList(origin.split("[.,!:;? ]"));
        HashSet<String> hashSet = new HashSet<>(originList);
        List<String> lineList = Arrays.asList(line.split("[.,!:;? ]"));
        return !hashSet.addAll(lineList);
    }
}