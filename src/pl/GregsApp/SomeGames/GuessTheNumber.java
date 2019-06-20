package pl.GregsApp.SomeGames;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {


        Random generator = new Random();
        Scanner scan = new Scanner(System.in);

        int numberFromUser;
        int randomNumber = generator.nextInt(101);


            while(true) {
                System.out.println("Zgadnij liczbę!");

                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("To nie liczba, proszę podaj liczbe!");
                }

                numberFromUser = scan.nextInt();

                while (numberFromUser < randomNumber) {
                    System.out.println("za mało");
                    break;
                }
                while (numberFromUser > randomNumber) {
                    System.out.println("za dużo");
                    break;
                }
                if(numberFromUser == randomNumber){
                    System.out.println("zgadłeś! brawo! :)");
                    break;
                }
            }

    }
}
