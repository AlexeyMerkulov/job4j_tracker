package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void whenTransformFourStudents() {
        Student first = new Student(100, "Petrov");
        Student second = new Student(70, "Petrov");
        Student third = new Student(50, "Sidorov");
        Student fourth = new Student(30, "Ivanov");
        List<Student> students = List.of(first, second, third, fourth);
        Map<String, Student> rsl = ListToMap.transform(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Petrov", new Student(100, "Petrov"));
        expected.put("Sidorov", new Student(50, "Sidorov"));
        expected.put("Ivanov", new Student(30, "Ivanov"));
        assertThat(expected, is(rsl));
    }
}