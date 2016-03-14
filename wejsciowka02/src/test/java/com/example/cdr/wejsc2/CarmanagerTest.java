package com.example.cdr.wejsc1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class CarmanagerTest{

    private Carmanager manager = new Carmanager();
    private Carmanager manager2 = new Carmanager();
    private Car ca = new Car("opel", 1997, true);
    private Car ca2 = new Car("honda", 2013, false);
	private Car Car;
	private Car mock;
    
	@Before
	public void setUp() {
		mock = createMock(Car.class);
		Carmanager = new Carmanager(mock);
	}
	
	@Test
	public void addCheck(){
	    manager.addCar(ca);
	    manager2.addCar(ca);

         List<Car> mock = new ArrayList<Car>();
        mock.add(ca);
        replay(mock);
		 assertEquals(mock, manager.getCars());
		 verify(mock);
    }

    @Test
    public void subCheck()
    {
        manager.addCar(ca);
        manager.addCar(ca2);
	manager.deleteCar(ca2);

	List<Car> expected = new ArrayList<Car>();
	expected.add(ca);
        assertEquals(expected, manager.getCars());

    }


}
