/**
 * Задание: метод принимает 2 списка и элемент,
 * который возможно содержится в этих списках.
 * Вам необходимо проверить оба списка, содержат ли они одновременно этот элемент,
 * если содержит - необходимо удалить элемент из первого списка.
 * Потом второй список нужно добавить в первый. Метод должен вернуть индекс элемента,
 * который пришел в параметрах метода из общего списка.
 */

package ru.job4j.exercises;

import java.util.List;

public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        int rsl = -1;
        if (left.contains(str) && right.contains(str)) {
            left.remove(str);
            left.addAll(right);
            rsl = left.indexOf(str);
        } else if (left.contains(str)) {
            rsl = left.indexOf(str);
        } else if (right.contains(str)) {
            rsl = right.indexOf(str);
        }
        return rsl;
    }
}