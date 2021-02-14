/**
 * Необходимо реализовать метод, который генерирует геометрическую прогрессию
 * и при этом принимает 3 значения:
 *
 * 1. Первый элемент геометрической прогрессии;
 *
 * 2. Знаменатель прогрессии;
 *
 * 3. Количество элементов, которое должно содержаться в сгенерированной последовательности.
 *
 * При этом метод должен вернуть сумму элементов сгенерированной последовательности.
 */
package ru.job4j.exercises;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            int number = first * (int) (Math.pow(denominator, i - 1));
            list.add(number);
        }
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}