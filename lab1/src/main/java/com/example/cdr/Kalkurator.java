package com.example.cdr;

public class Kalkurator {

	
	 public Kalkurator() {
		 System.out.println("Kalkurator: " + this);
		 
	 }
	 public int add(int n1, int n2){
		 return n1 + n2;
	 }
	 public int sub(int n1, int n2){
		 return n1 - n2;
	 }
	 public int multi(int n1, int n2){
		 return n1 * n2;
	 }
	 public int div(int n1, int n2){
		 return n1 / n2;
	 }
	 public boolean greater(int n1, int n2){
		 return n1 > n2;
	 }
}
