package com.example.demo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
public class NumberServiceTest {
    private final NumberService numberService = new NumberService();
    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, false",
        "10, true",
        "11, false",
        "0, true"
    })
    void testIsEven(int input, boolean expected) {
        boolean result = numberService.isEven(input);
        assertEquals(expected, result, "Check if number is even");
    }
}
