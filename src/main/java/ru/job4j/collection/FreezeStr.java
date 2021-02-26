package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        Map<Character, Integer> check = new HashMap<>();
        for (Character c : leftArray) {
            if (check.containsKey(c)) {
                check.compute(c, (key, value) -> value + 1);
            } else {
                check.put(c, 1);
            }
        }
        for (Character c : rightArray) {
            if (!check.containsKey(c)) {
                rsl = false;
                break;
            }
            if (check.containsKey(c) && check.get(c) == 1) {
                check.remove(c);
                continue;
            }
            check.compute(c, (key, value) -> value - 1);
        }
        return rsl;
    }
}

