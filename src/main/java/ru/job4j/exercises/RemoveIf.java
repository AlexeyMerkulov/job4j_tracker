/**
 * Задание: необходимо реализовать метод, который вернет список строк,
 * которые состоят из 5 и более символов.
 */
package ru.job4j.exercises;

import java.util.List;

public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        list.removeIf(x -> x.length() < 5);
        return list;
    }
}