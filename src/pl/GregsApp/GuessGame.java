package pl.GregsApp;



import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {

        Random generator = new Random();

        Scanner scanner = new Scanner(System.in);
        int appNumber = generator.nextInt(101)+1;
        int typeNumber = 0;

        System.out.println("Zgadnij liczbę");


        while(true) {
            while (!scanner.hasNextInt()) {
                System.err.println("To nie jest liczba!");
                scanner.nextLine();}
                typeNumber = scanner.nextInt();
                if (typeNumber < appNumber) {
                    System.out.println("Za mało");
                    scanner.hasNextInt();
                }
                else if (typeNumber > appNumber) {
                    System.out.println("Za dużo!");
                    scanner.hasNextInt();

                } else if (typeNumber == appNumber) {
                    System.out.println("Zgadłeś");
                    break;

                }
            scanner.nextLine();



        }








    }
}
