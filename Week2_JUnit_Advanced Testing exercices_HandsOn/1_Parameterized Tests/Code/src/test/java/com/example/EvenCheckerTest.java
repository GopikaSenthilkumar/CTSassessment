package com.example;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class EvenCheckerTest {
    private final EvenChecker checker = new EvenChecker();
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, 0, -2})
    void shouldReturnTrueForEvenNumbers(int num) {
        assertTrue(checker.isEven(num), num + " should be even");
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 101, -1})
    void shouldReturnFalseForOddNumbers(int num) {
        assertFalse(checker.isEven(num), num + " should be odd");
    }
}
