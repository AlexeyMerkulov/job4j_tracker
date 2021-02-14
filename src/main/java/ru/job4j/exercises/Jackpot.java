/**
 * Выигрышной комбинацией для джекпота в казино считается такая,
 * в которой все элементы одинаковые.
 *
 * Метод принимает массив строк, который содержит последовательность
 * элементов игровой комбинации. Метод должен вернуть true - если комбинация является выигрышной.
 */
package ru.job4j.exercises;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        boolean rsl = false;
        Set<String> list = new HashSet<>(Arrays.asList(combination));
        int size = list.size();
        if (size == 1) {
            rsl = true;
        }
        return rsl;
    }
}