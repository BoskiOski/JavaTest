package com.example.cdr;

public class Kalkulator2 {


	 public Kalkulator2() {
		 System.out.println("Kalkulator: " + this);

	 }
	 public double add(double n1, double n2){
		 return n1 + n2;
	 }
	 public double sub(double n1, double n2){
		 return n1 - n2;
	 }
	 public double multi(double n1, double n2){
		 return n1 * n2;
	 }
	 public double div(double n1, double n2){
		 if( n2 == 0 )
			throw new ArithmeticException("Dzielenie przez 0!");
		 return n1 / n2;
	 }
	 public boolean greater(double n1, double n2){
		 return n1 > n2;
	 }
}

