package com.oozeander.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(IntegrationTest.class)
@Categories.ExcludeCategory(UnitTest.class)
@Suite.SuiteClasses({com.oozeander.exception_ignore.CalculatorTest.class})
public class CalculatorTest {
}