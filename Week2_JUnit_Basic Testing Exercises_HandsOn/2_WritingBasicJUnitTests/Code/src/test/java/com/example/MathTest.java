package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class MathTest {
	Math sm = new Math();
	@Test
	 void testAdd() {
	     assertEquals(8, sm.add(5, 3));
	     assertEquals(0, sm.add(-2, 2));
	     assertNotEquals(10, sm.add(2, 3));
	 }
	 @Test
	 void testIsEven() {
	     assertTrue(sm.isEven(4));
	     assertFalse(sm.isEven(7));
	     assertTrue(sm.isEven(0));  
	 }
	 @Test
	 void testMax() {
	     assertEquals(9, sm.max(3, 9));
	     assertEquals(10, sm.max(10, 5));
	     assertEquals(-1, sm.max(-1, -4));
	 }
}
