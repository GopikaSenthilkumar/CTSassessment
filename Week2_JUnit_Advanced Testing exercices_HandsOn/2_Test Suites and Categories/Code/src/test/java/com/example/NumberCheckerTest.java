package com.example;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
public class NumberCheckerTest {
    @Test
    void testOddCheck() {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(5));
    }
}