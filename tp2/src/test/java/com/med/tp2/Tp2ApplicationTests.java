package com.med.tp2;

import com.med.tp2.services.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Tp2ApplicationTests {
	@Autowired
	private CalculatorService calculatorService;


	@Test
	void testAdd() {
		int result = calculatorService.add(2, 3);
		assertEquals(5, result);
	}
	@Test
	void testSubtract() {
		int result = calculatorService.subtract(5, 3);
		assertEquals(2, result);
	}
	@Test
	void testMultiply() {
		int result = calculatorService.multiply(2, 3);
		assertEquals(6, result);
	}
	@Test
	void testDivide() {
		double result = calculatorService.divide(6, 3);
		assertEquals(2.0, result);
	}
	@Test
	void testDivideByZero() {
		try {
			calculatorService.divide(6, 0);
		} catch (IllegalArgumentException e) {
			assertEquals("Division by zero is not allowed.", e.getMessage());
		}
	}
	@Test
	void testDivideNegative() {
		double result = calculatorService.divide(-6, 3);
		assertEquals(-2.0, result);
	}
	@Test
	void testDividePositive() {
		double result = calculatorService.divide(6, -3);
		assertEquals(-2.0, result);
	}
	@Test
	void testDivideNegativeByNegative() {
		double result = calculatorService.divide(-6, -3);
		assertEquals(2.0, result);
	}

}
