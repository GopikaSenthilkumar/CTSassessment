package com.example;
import static org.junit.Assert.*;
import org.junit.Test;
public class CalculatorTest {
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals("Sum is 15", 15, calc.add(10, 5));
    }
    @Test
    public void testSquare() {
        Calculator calc = new Calculator();
        assertEquals("Square of 4 is 16", 16, calc.square(4));
    }
    @Test
    public void testIsEven() {
        Calculator calc = new Calculator();
        assertTrue("10 is even", calc.isEven(10));
        assertFalse("3 is not even", calc.isEven(3));
    }
}
