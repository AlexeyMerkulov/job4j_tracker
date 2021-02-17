/**
 * В данном задании необходимо реализовать словарь.
 * Метод принимает массив строк. Необходимо перебрать массив
 * и добавить строки в карту таким образом, чтобы ключом
 * был первый символ строки, а значением - список строк,
 * которые начинаются на первый символ строки.
 */
package ru.job4j.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String s : strings) {
            char c = s.charAt(0);
            List<String> list = new ArrayList<>();
            for (String g : strings) {
                if (g.charAt(0) == c) {
                    list.add(g);
                }
            }
            String str = Character.toString(c);
            rsl.put(str, list);
        }
        return rsl;
    }
}