package com.example.cdr.wejsc2;

public interface ICar{
	public boolean add(Car car);
	public boolean remove(Car car);
	public Car get(int nazwa);
	public Car findCarByMarka(String marka);
	public List<Car> findCarsByRocznik(int rocznik);
}
