package pl.GregsApp.SomeGames;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class wordSearch {

    public static void main(String[] args){

        // zapis nagłówków do pliku tekstowego
        // pobieranie naglowkow artykulow z onetu i ich przefiltrowanie
        Path path = Paths.get("src/pl/GregsApp/SomeGames/popular_words.txt");
        Connection connect = Jsoup.connect("http://www.onet.pl/");

        try {
            PrintWriter writer = new PrintWriter(path.toFile());
            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
                System.out.println(elem.text());
                String[] line = elem.text().split("[ :!?;,\\.\"]+"); // regex
                for (String word : line){
                    writer.println(word);
                }
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //zapis przefiltrowanych danych do pliku tekstowego

        String[] skipWord = {"ponieważ","który","która","które","oraz","czyli","przed"};
        Path pathToFilteredFile = Paths.get("src/pl/GregsApp/SomeGames/filtered_popular_words.txt");

        try {
            PrintWriter filteredWritter = new PrintWriter(pathToFilteredFile.toFile());
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                boolean write = true;
                String word = scanner.nextLine();
                for(int i = 0; i < skipWord.length; i++){ //pomin słowa
                    if(skipWord[i].equals(word)) {
                        write = false;
                    }
                }
                if((word.length() > 3) && write) { //zapisuj słowa dłuższe niż 3 znaki
                    filteredWritter.println(word);
                }
            }
            filteredWritter.close();
        }catch(IOException e){
            System.out.println("Nie odnaleziono pliku ze słowami");
        }



    }
}
