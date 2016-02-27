package com.example.cdr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Kalkulator2Test {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Kalkulator2 kalk = new Kalkulator2();

	@Test
	public void addCheck(){
		assertEquals(5.32, kalk.add(3.20, 2.12), 0.01);
	}
	@Test
	public void subCheck(){
		assertEquals(1.10, kalk.sub(3.40, 2.30), 0.01);
	}
	@Test
	public void multiCheck(){
        assertEquals(6.8, kalk.multi(3.40, 2.02), 0.07);
	}
	@Test
	public void divCheck(){
		assertEquals(2.09, kalk.div(4.60, 2.20), 0.09);
	}
	@Test
	public void greaterCheck(){
        assertTrue(kalk.greater(3.40, 2.20));
		assertFalse(kalk.greater(2.50, 3.60));
	}
	@Test
	public void empty() {
	    thrown.expect(ArithmeticException.class);
	    kalk.div(5.60, 0);
	}
}
