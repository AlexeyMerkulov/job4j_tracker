/**
 * Задание: метод принимает два параметра - список и элемент,
 * который предполагается, что содержится в этом списке.
 * Необходимо реализовать метод, чтобы он возвращал результаты следующим образом:
 *
 * 1. Элемента нет в списке - возвращает пустой список.
 *
 * 2. Элемент в списке встречается 1 раз - возвращает пустой список.
 *
 * 3. Элемент встречается более одного - возвращается список,
 * начиная с первого вхождения элемента и заканчивая предшествующим
 * последнему вхождению элемента в исходной коллекции.
 */
package ru.job4j.exercises;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        List<String> rsl = new ArrayList<>();
        int first = list.indexOf(el);
        int second = list.lastIndexOf(el);
        if (!list.contains(el) || first == second) {
            rsl = List.of();
        } else {
            rsl = list.subList(first, second);
        }
        return rsl;
    }
}