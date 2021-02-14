package ru.job4j.exercises;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int sum = 0;
        boolean logic = true;
        for (int i = 1; i < data.size() - 1; i++) {
            if ((data.get(i - 1) + data.get(i + 1)) * 0.5 != data.get(i)) {
                logic = false;
                break;
            }
        }
        if (logic) {
            for (int in : data) {
                sum += in;
            }
        }
        return sum;
    }
}