package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Calculation.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = Calculation.diapason(2, 5, x -> x * x + 5);
        List<Double> expected = Arrays.asList(9D, 14D, 21D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = Calculation.diapason(4, 7, x -> Math.pow(2, x) - 2);
        List<Double> expected = Arrays.asList(14D, 30D, 62D);
        assertThat(result, is(expected));
    }
}