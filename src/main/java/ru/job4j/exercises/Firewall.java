/**
 * Метод принимает строку, которая является названием статьи,
 * а также коллекцию Set в которой содержатся слова,
 * которые не должны содержаться в названиях статей,
 * чтобы мы могли сконцентрироваться на материале изучения. Метод должен вернуть:
 *
 * 1. Если в строке нет ни одного слова из коллекции Set, то метод должен вернуть строку:
 * Вы сделали правильный выбор!
 *
 * 2. Если в строке имеется хоть одно из слов из коллекции Set, метод должен вернуть строку:
 * Выберите другую статью...
 */
package ru.job4j.exercises;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        Set<String> copy = new HashSet<>(words);
        String out = "";
        List<String> strings = Arrays.asList(s.split(" "));
        boolean rsl = copy.removeAll(strings);
        if (rsl) {
            out = "Выберите другую статью...";
        } else {
            out = "Вы сделали правильный выбор!";
        }
        return out;
    }
}