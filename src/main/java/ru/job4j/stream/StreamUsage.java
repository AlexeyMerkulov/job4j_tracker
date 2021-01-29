package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(0, -2, 31, -100, 85, -5, 65);
        List<Integer> dest = source.stream().filter(x -> x > 0).collect(Collectors.toList());
    }
}
