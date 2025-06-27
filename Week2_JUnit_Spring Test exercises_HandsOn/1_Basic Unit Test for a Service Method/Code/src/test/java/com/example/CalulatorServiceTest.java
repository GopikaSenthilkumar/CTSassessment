package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorServiceTest {
    @Test
    void testAddition() {
        CalculatorService calculator = new CalculatorService();
        int result = calculator.add(10, 20);
        assertEquals(30, result);
    }
}  
