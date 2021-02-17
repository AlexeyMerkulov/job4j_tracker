/**
 * Метод принимает строку, которая может содержать несколько пробелов,
 * однако в ней отсутствуют знаки препинания.
 *
 * Необходимо реализовать метод, который вернет символ в строке,
 * который употребляется наибольшее количество раз.
 * Если окажется что таких символов несколько - необходимо вернуть первый из символов.
 * Чтобы обеспечить сортировку символов - собирайте исходную строку в TreeMap(),
 * в которой ключ - это символ, значение - количество. Перед тем как собирать строку
 * ее нужно привести к нижнему регистру, удалить пробелы
 */
package ru.job4j.exercises;

import java.util.Map;
import java.util.TreeMap;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        char rsl = ' ';
        String lowStr = str.toLowerCase();
        String[] strArray = lowStr.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s);
        }
        char[] chArray = sb.toString().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (Character c : chArray) {
            map.computeIfPresent(c, (key, value) -> value + 1);
            map.putIfAbsent(c, 1);
        }
        int max = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                rsl = c;
            }
        }
        return rsl;
    }
}