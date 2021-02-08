package com.oozeander.exception_ignore;

import com.oozeander.Calculator;
import com.oozeander.categories.IntegrationTest;
import com.oozeander.categories.UnitTest;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.fail;

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

    @Test(expected = ArithmeticException.class)
    @Category(IntegrationTest.class)
    public void test_exception_first() {
        // GIVEN
        int a = 1, b = 0;
        // WHEN
        int actual = calculator.divide(a, b);
    }

    @Test
    @Category(IntegrationTest.class)
    public void test_exception_second() {
        // GIVEN
        int a = 1, b = 0;
        // WHEN
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(
                () -> calculator.divide(a, b)
        ); // check message / cause / ...
    }

    @Test
    @Ignore
    @Category(UnitTest.class)
    public void test_ignored() {
        fail("Not yet implemented");
    }
}