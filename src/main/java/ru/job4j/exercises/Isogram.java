/**
 * Изограмма - это слово, которое не содержит повторяющихся букв,
 * т.е. все буквы в таком слове уникальные.
 *
 * Метод принимает на входе строку, которая является словом,
 * все буквы написаны в нижнем регистре. Входная строка - не фраза, а одно слово,
 * поэтому ее не нужно делить на слова.
 *
 * Метод должен вернуть булево значение -
 * если слово является изограммой - то метод вернет true, иначе - false.
 */
package ru.job4j.exercises;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Isogram {
    public static boolean checkString(String s) {
        boolean rsl = false;
        String[] array = s.split("");
        Set<String> list = new HashSet<>(Arrays.asList(array));
        if (list.size() == s.length()) {
            rsl = true;
        }
        return rsl;
    }
}