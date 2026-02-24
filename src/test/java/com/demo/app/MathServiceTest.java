package com.demo.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    void testAdd() {
        assertEquals(5, mathService.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(6, mathService.subtract(10, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(12, mathService.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(5.0, mathService.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathService.divide(10, 0));
    }

    @Test
    void testGreet() {
        assertEquals("Hello, Alice!", mathService.greet("Alice"));
    }

    @Test
    void testGreetTrimsWhitespace() {
        assertEquals("Hello, Bob!", mathService.greet("  Bob  "));
    }

    @Test
    void testGreetThrowsIfEmpty() {
        assertThrows(IllegalArgumentException.class, () -> mathService.greet(""));
    }

    @Test
    void testGreetThrowsIfNull() {
        assertThrows(IllegalArgumentException.class, () -> mathService.greet(null));
    }
}
