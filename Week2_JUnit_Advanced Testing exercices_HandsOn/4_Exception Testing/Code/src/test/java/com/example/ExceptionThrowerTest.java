package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ExceptionThrowerTest {
	 @Test
	    void testThrowsIllegalArgumentException() {
	        ExceptionThrower thrower = new ExceptionThrower();

	        IllegalArgumentException exception = assertThrows(
	            IllegalArgumentException.class,
	            () -> thrower.throwException(null)
	        );

	        assertEquals("Input cannot be null", exception.getMessage());
	    }
}
