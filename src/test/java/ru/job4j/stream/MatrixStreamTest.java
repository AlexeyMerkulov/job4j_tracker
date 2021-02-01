package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixStreamTest {

    @Test
    public void whenTransformMatrixToList() {
        Integer[][] in = {{1, 2, 3},
                          {4, 5, 6}};
        List<Integer> rsl = MatrixStream.matrixToList(in);
        List<Integer> expected = List.of(1, 2, 3,
                                         4, 5, 6);
        assertThat(rsl, is(expected));
    }
}