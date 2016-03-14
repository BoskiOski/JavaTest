package com.example.cdr.wejsc2;


public class Car{
    private String marka;
    private int rocznik;
    private Boolean sprawnosc;


        public Car(String marka, int rocznik, Boolean sprawnosc ) {

            this.marka = marka;
            this.rocznik = rocznik;
            this.sprawnosc = sprawnosc;


        }
        
        public String getName() {
        	return marka;
        }
}

