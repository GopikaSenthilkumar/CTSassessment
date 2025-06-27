package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerAssertionTest {
	@Test
    public void testVariousAssertions() {
        int exps = 5;
        int acts = 2 + 3;
        assertEquals(exps, acts, "Sum of 2 and 3 be 5");
        boolean isGreater = 5 > 3;
        assertTrue(isGreater, "5 should be greater than 3");
        boolean isLess = 5 < 3;
        assertFalse(isLess, "5 should not be less than 3");
        Object obj = null;
        assertNull(obj, "Object should be null");
        Object nonNullObject = new Object();
        assertNotNull(nonNullObject, "Object should not be null");
    }

}
