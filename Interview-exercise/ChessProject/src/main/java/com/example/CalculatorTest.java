package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "Adding positive numbers");
        assertEquals(0, calculator.add(0, 0), "Adding zeros");
        assertEquals(-5, calculator.add(-2, -3), "Adding negative numbers");
        assertEquals(0, calculator.add(-2, 2), "Adding inverse numbers");
        assertEquals(1000000, calculator.add(500000, 500000), "Adding large numbers");
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "Subtracting positive numbers");
        assertEquals(0, calculator.subtract(0, 0), "Subtracting zeros");
        assertEquals(1, calculator.subtract(-2, -3), "Subtracting negative numbers");
        assertEquals(-4, calculator.subtract(-2, 2), "Subtracting a positive from a negative");
        assertEquals(0, calculator.subtract(500000, 500000), "Subtracting large numbers");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "Multiplying positive numbers");
        assertEquals(0, calculator.multiply(0, 5), "Multiplying with zero");
        assertEquals(6, calculator.multiply(-2, -3), "Multiplying negative numbers");
        assertEquals(-4, calculator.multiply(-2, 2), "Multiplying a negative and a positive");
        assertEquals(250000000, calculator.multiply(50000, 5000), "Multiplying large numbers without overflow");
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "Dividing positive numbers");
        assertEquals(0, calculator.divide(0, 5), "Dividing zero by a number");
        assertEquals(1, calculator.divide(-3, -3), "Dividing negative numbers");
        assertEquals(-2, calculator.divide(-4, 2), "Dividing negative by positive");
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw ArithmeticException");
    }
}
