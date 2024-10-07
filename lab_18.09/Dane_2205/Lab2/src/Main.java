import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("liczby.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String liczba = (scanner.nextLine());
                String pliczba = liczba.substring(0,1);
                String oliczba = liczba.substring(liczba.length()-1);
                if(oliczba.equals(pliczba)){
                    System.out.println(liczba);

                }

            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void function(int num){

    }
}
