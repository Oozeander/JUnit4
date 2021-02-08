package com.oozeander.lifecyclehooks;

import com.oozeander.Calculator;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculatorTest {
    private Calculator calculator;
    private static Instant start;

    @BeforeClass
    public static void init() {
        start = Instant.now();
    }

    @AfterClass
    public static void destroy() {
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Tests took " + duration + " ms");
    }

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @After
    public void teardown() {
        calculator = null;
    }

    @Test
    public void test_add() {
        // GIVEN
        int a = 5, b = 2;
        // WHEN
        int expected = 7, actual = calculator.add(a, b);
        // THEN
        assertThat(actual).isEqualTo(expected);
    }
}