package pl.GregsApp.SomeGames;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSimulation {

    // Losowanie lotto, zakres od 1 do 49, podajemy 6 liczb i sprawdzamy czy trafilismy 3,4,5 a moze 6

    public static void main(String[] args) {
        // 6 liczb z 1 do 49
        // zgadnij liczby
        //3,4,5 lub 6 jest nagradzane
        int[] inputNumbersArray = new int[6];
        int[] randomArray = new int[6];
        int count = 0;
        int tempNumber = 0;

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Proszę podaj 6 liczb, w zakresie od 1 do 49, liczby nie mogą się powtarzać");

        for(int i = 0; i < 6; i++) {

            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Błąd, wprowadź liczbę");
            }

            tempNumber = scan.nextInt();

            if(!ArrayUtils.contains(inputNumbersArray, tempNumber) && tempNumber >= 1 && tempNumber <= 49){
                inputNumbersArray[i] = tempNumber;
            }
            else {
                System.out.println("Proszę o podanie różnych liczb w zakresie 1-49");
            }

        }


        ////losowe liczby

        for(int i = 0; i < randomArray.length; i++){
            randomArray[i] = random.nextInt(50)+1;
        }

        System.out.println("Liczby wylosowane przez maszyne");
        Arrays.sort(randomArray);

        for(int randNumebrs : randomArray){
            System.out.print(randNumebrs + "   ");
        }




        System.out.println("\n\n");

        System.out.println("Wprowadzone liczby: ");

        Arrays.sort(inputNumbersArray);
        for(int numbers : inputNumbersArray){
            System.out.print(numbers + "   ");
        }

        for(int i = 0; i < 6; i++) {
                if (ArrayUtils.contains(randomArray, inputNumbersArray[i])) {
                    count++;
                }

        }

        numbAsnwers(count);

    }
    // mozna bylo switcha uzyc, bylo by czytelniej
    public static int numbAsnwers(int count){
        if(count == 0){
            System.out.println("niestety nie zgadłeś nic");
        }
        else if(count == 1){
            System.out.println("zgadłeś " + count + " liczbę, niestety to za mało");
        }
        else if(count == 2){
            System.out.println("zgadłeś " + count + " liczby, niestety to za mało");
        }
        else if(count == 3){
            System.out.println("zgadłeś" + count + " liczby, brawo! na 6, trafiłeś 3!,");
        } else if (count == 4) {
            System.out.println("zgadłeś" + count + " liczby, brawo! na 6 trafiłeś aż 4!, nieźle!");
        }
        else if(count == 5) {
            System.out.println("BRAWO!!, zgadłeś aż" + count + " liczb!, świetny wynik!");
        }
        else if(count == 6){
            System.out.println("WOW!! Trafiłeś szóstkę!!, WOW!!! BRAWAA, Rozjebałeś tą giereczke kolego!");
        }

        return count;

    }


}
