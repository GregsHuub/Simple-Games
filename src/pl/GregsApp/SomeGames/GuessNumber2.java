package pl.GregsApp.SomeGames;

import java.util.Scanner;

public class GuessNumber2 {

    public static void main(String[] args) {

        // gra zgaduję liczbę, która podaję użytkownik, odpowiadamy

        System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę w max. 10 próbach");
        System.out.println("*********");
        System.out.println("jeżeli podana liczba jest za duża wpisz - za dużo");
        System.out.println("jeżeli podana liczba jest za mała wpisz - za mało");
        System.out.println("*********");
        System.out.println("Na zapytanie czy zgadł, odpowiadaj tak lub nie :) ENJOY");
        System.out.println("*********");
        String toMuch = "za dużo";
        String notEnough = "za mało";
        int min = 0;
        int max = 1000;
        String inputYesOrNot;
        String inputValue;


        Scanner scan = new Scanner(System.in);



            for(int i = 0; i < 10; i++) {

                int guess = ((max - min) / 2) + min;

                System.out.println("zagduję: " + guess);

                System.out.println("zgadłem?");

                inputYesOrNot = scan.nextLine();

                if (inputYesOrNot.equals("tak")) {
                    System.out.println("Wygrałem!");
                    break;

                } else if (inputYesOrNot.equals("nie")) {
                    System.out.println("za dużo czy za mało?");
                }

                inputValue = scan.nextLine(); // pobrana wartosc za duzo lub za malo

                if (inputValue.equals(toMuch)) {
                    max = guess;
                    System.out.println("A teraz?");
                } else if (inputValue.equals(notEnough)) {
                    min = guess;
                    System.out.println("A teraz?");
                }
                else {
                    System.out.println("nie oszukuj!");
                }
            }
    }


}
