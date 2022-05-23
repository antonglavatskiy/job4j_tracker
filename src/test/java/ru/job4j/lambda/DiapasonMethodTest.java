package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonMethodTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonMethod.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        List<Double> result = DiapasonMethod.diapason(2, 5, x -> x * x + 5);
        List<Double> expected = Arrays.asList(9D, 14D, 21D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        List<Double> result = DiapasonMethod.diapason(1, 4, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(5D, 25D, 125D);
        assertThat(result, is(expected));
    }
}