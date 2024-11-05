import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("Dane_PR2/lab2/liczby.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                int liczba = Integer.parseInt(scanner.nextLine());


                if (f(liczba)) {
                    System.out.println(liczba);
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean f(int number) {

        while (number % 3 == 0) {
            number /= 3;
        }
        return number == 1;
    }
}