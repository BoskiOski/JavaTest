package com.example.cdr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KalkulatorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private Kalkurator kalk = new Kalkurator();
	
	@Test
	public void addCheck(){
		 System.out.println("AddCheck: " + this);
		assertEquals(5, kalk.add(3, 2));
	}
	@Test
	public void subCheck(){
		 System.out.println("SubCheck: " + this);
		assertEquals(1, kalk.sub(3, 2));
	}
	@Test
	public void multiCheck(){
		 System.out.println("multiCheck: " + this);
		assertEquals(6, kalk.multi(3, 2));
	}
	@Test
	public void divCheck(){
		 System.out.println("divCheck: " + this);
		assertEquals(2, kalk.div(4, 2));
	}
	@Test
	public void greaterCheck(){
		 System.out.println("greaterCheck: " + this);
		assertTrue(kalk.greater(3, 2));
		assertFalse(kalk.greater(2, 3));
	}
	@Test
	public void empty() { 
	    thrown.expect(ArithmeticException.class);
	    kalk.div(5, 0);
	}
}
