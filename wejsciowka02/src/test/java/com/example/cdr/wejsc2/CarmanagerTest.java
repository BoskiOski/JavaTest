package com.example.cdr.wejsc2;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;


import java.util.*;

public class CarmanagerTest{

    private Carmanager manager;
	private ICar mock;

	private List<Car> cara;

	@Before
	public void setUp() {
		mock = createMock(ICar.class);
		manager = new Carmanager(mock);
	}

	@Test
	public void addCheck(){
		Car ca = new Car("Opel", 1992, true);
        expect(mock.add(ca)).andReturn(true);
        expect(mock.get(1)).andReturn(ca);
        replay(mock);
        manager.addCar(ca);
		assertEquals("Opel", manager.getCars(1).getName());
		verify(mock);
    }
    @Test
    public void findCarByMarkaCheck(){
        Car car3 = new Car("Mazda",1990, true);
        expect(mock.findCarsByMarka("Mazda")).andReturn(car3).atLeastOnce();
        replay(mock);
        assertEquals(car3, manager.findCarsByMarka("Mazda"));
        verify(mock);
    }
    @Test
    public void findCarByRocznikCheck(){
        Car car4 = new Car("Fiat",1980, true);
        expect(mock.findCarsByRocznik(1980)).andReturn(cara).atLeastOnce();
        replay(mock);
        assertEquals(cara, manager.findCarsByRocznik(1980));
        verify(mock);


    }


}
