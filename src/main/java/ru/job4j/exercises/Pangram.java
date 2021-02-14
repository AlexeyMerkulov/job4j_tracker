/**
 * Метод принимает строку(на английском языке).
 * Необходимо реализовать его так, чтобы метод определил
 * является ли входящая строка панграммой.
 * Строчные и прописные буквы являются одинаковыми символами,
 * пробелы необходимо игнорировать.
 */
package ru.job4j.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        boolean rsl = false;
        String[] strings = s.split("");
        Set<String> setStr = new HashSet<>(Arrays.asList(strings));
        setStr.removeAll(List.of(" "));
        if (setStr.size() == 26) {
            rsl = true;
        }
        return rsl;
    }
}