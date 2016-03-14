package com.example.cdr.wejsc1;

import java.util.*;

public class Carmanager{



        private List<Car> lista = new ArrayList<Car>();
        public void addCar (Car samochod) {
        lista.add(samochod);
        }

        public void deleteCar (Car samochod) {
        lista.remove(samochod);
        }

        public List<Car> getCars() {
            return lista;
        }

    }


