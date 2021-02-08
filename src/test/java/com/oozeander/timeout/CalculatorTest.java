package com.oozeander.timeout;

import com.oozeander.Calculator;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {
    private Calculator calculator;
    @Rule
    public Timeout timeout = Timeout.millis(120);

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @After
    public void teardown() {
        calculator = null;
    }

    @Test // 120 ms
    public void test_timeout() {
        // GIVEN
        int[] array = {1, 2, 3, 4, 5, 6};
        int amountToAdd = 10;
        // WHEN
        int[] expected = {11, 12, 13, 14, 15, 16}, actual = calculator.addEach(array, amountToAdd);
        // THEN
        assertThat(actual).containsExactly(expected);
    }

    /*
    Lower timeout overrides
     */
    @Test(timeout = 50) // 50 ms
    public void test_timeoutRule() {
        assertThat(true).isTrue();
    }
}