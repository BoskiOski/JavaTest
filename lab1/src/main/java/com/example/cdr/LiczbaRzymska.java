package com.example.cdr;

public class LiczbaRzymska {
    private int liczba_arabska;

    //konstruktor
    LiczbaRzymska(int liczba){
        liczba_arabska = liczba;
    }

    public String toString() {
         final int arabic[] = {1000, 500, 100, 50, 10, 5, 1};
         final char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
         final int ROMAN_N = arabic.length;

        int i = 0;
        String result = "";
        if ((liczba_arabska > 3999) || (liczba_arabska <= 0)) {
            return result;
        }
        while ((liczba_arabska > 0) && (i < ROMAN_N)) {
            if(liczba_arabska >= arabic[i])
            {
                liczba_arabska -= arabic[i];
                result += roman[i];
            }
            else if ((i%2 == 0) &&
            (i<ROMAN_N-2) && // 9xx condition
            (liczba_arabska >= arabic[i] - arabic[i+2]) &&
            (arabic[i+2] != arabic[i] - arabic[i+2]))
            {
                liczba_arabska -= arabic[i] - arabic[i+2];
                result += roman[i+2];
                result += roman[i];
                i++;
            }
            else if ((i%2 == 1) &&
            (i<ROMAN_N-1) && //4xx condition
            (liczba_arabska >= arabic[i] - arabic[i+1]) &&
            (arabic[i+1] != arabic[i] - arabic[i+1]))
            {
                liczba_arabska -= arabic[i] - arabic[i+1];
                result += roman[i+1];
                result += roman[i];
                i++;
            }
            else
            {
                i++;
            }
        }
        return result;
    }
}
