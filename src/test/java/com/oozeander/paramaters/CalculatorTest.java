package com.oozeander.paramaters;

import com.oozeander.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @After
    public void teardown() {
        calculator = null;
    }

    @Parameterized.Parameters(name = "{0} + {1} = {2}")
    public static Collection<Object[]> paramaters() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3}, {-1, 0, -1}, {-5, -7, -12}, {-1, 49, 48}
        });
    }

    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int result;

    @Test
    public void test_parameterized() {
        // GIVEN
        // WHEN
        int expected = result, actual = calculator.add(a, b);
        // THEN
        assertThat(actual).isEqualTo(expected);
    }
}