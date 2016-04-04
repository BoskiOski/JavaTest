package com.example.cdr.wejsc2;

import java.util.*;

public class Carmanager{

        private ICar lista;

        public Carmanager(ICar car) {
        	this.lista = car;
        }

        public void addCar (Car samochod) {
        lista.add(samochod);
        }

        public void deleteCar (Car samochod) {
        lista.remove(samochod);
        }

        public Car getCars(int at) {
            return lista.get(at);
        }

        public Car findCarsByMarka(String marka){
            return lista.findCarsByMarka(marka);
        }

        public List<Car> findCarsByRocznik(int rocznik){
            return lista.findCarsByRocznik(rocznik);
        }

    }


