package com.example.cdr.wejsc1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

public class CarmanagerTest{

    private Carmanager manager = new Carmanager();
    private Carmanager manager2 = new Carmanager();
    private Car ca = new Car("opel", 1997, true);
    private Car ca2 = new Car("honda", 2013, false);

    @Test
	public void addCheck(){
	    manager.addCar(ca);
	    manager2.addCar(ca);

         List<Car> proba = new ArrayList<Car>();
        proba.add(ca);

		 assertEquals(proba, manager.getCars());
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
