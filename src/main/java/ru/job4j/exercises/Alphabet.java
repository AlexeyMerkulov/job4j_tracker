/**
 * Необходимо реализовать метод, который принимает строку,
 * которое является одним словом, без знаков препинания цифр и пробелов.
 * Метод должен вернуть новую строку, в которой все символы
 * исходной строки будут расставлены в алфавитном порядке.
 */

package ru.job4j.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    public static String reformat(String s) {
        String[] array = s.split("");
        List<String> list = new ArrayList<>(Arrays.asList(array));
        list.sort(String::compareTo);
        StringBuilder rsl = new StringBuilder();
        for (String string : list) {
            rsl.append(string);
        }
        return rsl.toString();
    }
}