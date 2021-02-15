/**
 * Задание: Вам необходимо , чтобы в консоль были выведены все значения отображения.
 * При этом необходимо использовать метод keySet() и get().
 */

package ru.job4j.exercises;

import java.util.HashMap;
import java.util.Map;

public class KeySet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(
                Map.of(
                        1, "root@root",
                        2, "local@local",
                        3, "host@host"
                )
        );
        for (int num : map.keySet()) {
            System.out.println(num + " - " + map.get(num));
        }
    }
}