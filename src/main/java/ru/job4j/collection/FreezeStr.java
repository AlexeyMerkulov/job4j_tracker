package ru.job4j.collection;

        /*
        List<String> leftList = Arrays.asList(left.split(""));
        List<String> rightList = Arrays.asList(right.split(""));
        Collections.sort(leftList);
        Collections.sort(rightList);
        return leftList.equals(rightList);
        */

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] leftArray = left.split("");
        String[] rightArray = right.split("");
        Map<String, Integer> mapLeft = new HashMap<>();
        Map<String, Integer> mapRight = new HashMap<>();
        for (String s1 : leftArray) {
            if (mapLeft.containsKey(s1)) {
                mapLeft.compute(s1, (key, value) -> value + 1);
            } else {
                mapLeft.put(s1, 1);
            }
        }
        for (String s2 : rightArray) {
            if (mapRight.containsKey(s2)) {
                mapRight.compute(s2, (key, value) -> value + 1);
            } else {
                mapRight.put(s2, 1);
            }
        }
        return mapLeft.equals(mapRight);
    }
}
