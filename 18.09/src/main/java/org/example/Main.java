package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter wyniki = new FileWriter("wyniki.txt");
            Scanner plik = new Scanner(new File("./src/main/java/org/example/data/liczby.txt"));

            ArrayList<Integer> liczby = new ArrayList<>();

            while (plik.hasNextLine()) {
                liczby.add(Integer.parseInt(plik.nextLine()));
            }

            wyniki.write("Zadanie 4.1:\n");
            ArrayList<Integer> zad41 = zad41(liczby);
            wyniki.write(zad41.size() + " " + zad41.get(0) + "\n");




            wyniki.write("Zadanie 4.3:\n");
            List<Integer> zad43 = zad43(liczby);
            wyniki.write("a) " + zad43.get(0) + "\nb) " + zad43.get(1) + "\n");

            wyniki.write("Zadanie 4.2:\n");
            List<Integer> zad42 = zad42(liczby);
            wyniki.write(zad42.get(0) + " " + zad42.get(1) + " " + zad42.get(2) + " " + zad42.get(3) + "\n");

            wyniki.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie znaleziony");
        } catch (IOException e) {
            System.out.println("Błąd wejścia/wyjścia");
        }
    }

    private static ArrayList<Integer> zad41(ArrayList<Integer> liczby) {
        ArrayList<Integer> wynik = new ArrayList<>();

        for (int n : liczby) {
            int temp = n;

            int ostatniaCyfra = n % 10;

            while (n / 10 > 0) n /= 10;

            if (ostatniaCyfra == n) wynik.add(temp);
        }

        return wynik;
    }

    private static List<Integer> zad43(ArrayList<Integer> liczby) {
        int licznikTrojki = 0;
        int licznikPiatki = 0;

        try {
            FileWriter trojkiPlik = new FileWriter("trojki.txt");

            for (int x : liczby) {
                for (int y : liczby) {
                    if (x == y || x > y || y % x != 0) continue;

                    for (int z : liczby) {
                        if (y == z || y > z || z % y != 0) continue;
                        licznikTrojki++;


                        trojkiPlik.write(x + " " + y + " " + z + "\n");

                        for (int p : liczby) {
                            if (z == p || z > p || p % z != 0) continue;


                            for (int q : liczby) {
                                if (p == q || p > q || q % p != 0) continue;
                                licznikPiatki++;
                            }
                        }
                    }
                }
            }

            trojkiPlik.close();
        } catch (IOException e) {
            System.out.println("Błąd wejścia/wyjścia");



        }

        return List.of(licznikTrojki, licznikPiatki);
    }

    private static List<Integer> zad42(ArrayList<Integer> liczby) {
        int maxLiczba = 0;
        int maxCzynniki = 0;
        int maxRozneLiczby = 0;
        int maxRozneCzynniki = 0;

        List<Integer> liczbyPierwsze = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103);

        for (int n : liczby) {
            int temp = n;
            int liczbaCzynnikow = 0;
            int liczbaRoznych = 0;

            for (int i = 0; n > 1 && i < liczbyPierwsze.size(); i++) {
                if (n % liczbyPierwsze.get(i) == 0) liczbaRoznych++;
                while (n % liczbyPierwsze.get(i) == 0) {
                    liczbaCzynnikow++;
                    n /= liczbyPierwsze.get(i);


                }
            }

            if (liczbaRoznych > maxRozneCzynniki) {
                maxRozneLiczby = temp;
                maxRozneCzynniki = liczbaRoznych;
            }

            if (liczbaCzynnikow > maxCzynniki) {
                maxLiczba = temp;
                maxCzynniki = liczbaCzynnikow;



            }


            
        }

        return List.of(maxLiczba, maxCzynniki, maxRozneLiczby, maxRozneCzynniki);
    }
}
