package pl.GregsApp.SomeGames;

import java.util.Random;

public class dice {

    public static void main(String[] args){

        //Kostka do gier 2D10+10   - 2 RZUTY, KOSTKĄ D10 - 10-SCIENNA, +10 - DODAJ DO WYNIKU NP SUME Z POPRZEDNIOEGO RZUTU.

        String code = "2D10+10";
        System.out.println(diceThrow(code));

        System.out.println(diceThrow("2D10"));
        System.out.println(diceThrow("D6+500"));
        System.out.println(diceThrow("2D3"));
    }

    public static int diceThrow(String code){
        int result = 0;
        Random random = new Random();

        //jaki index ma D
        int dIndex = -1;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == 'D'){
                dIndex = i;
            }
        }

        //jaki indeks ma znak
        int signIndex = -1;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == '+' || code.charAt(i) == '-'){
                signIndex = i;
            }
        }

        //ile scian ma kostka
        int diceRange = 0;
        if(signIndex >= 0) {
            diceRange = Integer.parseInt(code.substring(dIndex+1, signIndex));
        }
        else {
            diceRange = Integer.parseInt(code.substring(dIndex+1));
        }

        //ile rzutów
        int throwCounter = 1;
        if(dIndex > 0){
            throwCounter = Integer.parseInt(code.substring(0,dIndex));
        }

        //dodaj lub odejmij od wyniku
        int shift = 0;
        if(signIndex > 0){
            shift = Integer.parseInt(code.substring(signIndex));
        }



        for(int i = 0; i < throwCounter; i++){
            int temp = (random.nextInt(diceRange)+1);
            result += temp;
            //System.out.println((i+1)+ ". rzut: " + temp);
        }
        result += shift;

        return result;
    }
}