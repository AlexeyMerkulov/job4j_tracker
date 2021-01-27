package ru.job4j.lambda;

import java.util.Comparator;

public class Example {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare in reverse order- " + left + " : " + right);
            return right.compareTo(left);
        };
    }
}
