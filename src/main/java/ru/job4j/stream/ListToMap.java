package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> transform(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        i -> i.getSurname(), Function.identity(), (
                                current, replacement) -> current));
    }

    public static void main(String[] args) {
        Student firstAddress = new Student(100, "Petrov");
        Student secondAddress = new Student(70, "Petrov");
        Student third = new Student(50, "Sidorov");
        Student fourth = new Student(30, "Ivanov");
        List<Student> students = List.of(firstAddress, secondAddress, third, fourth);

        Map<String, Student> rsl = ListToMap.transform(students);
        System.out.println(rsl);
    }
}
