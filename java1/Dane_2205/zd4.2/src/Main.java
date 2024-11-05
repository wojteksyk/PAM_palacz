import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("przyklad.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
        int liczba = sc.nextInt();
        int i=2;
        while (liczba % i==0 ) {
            System.out.println(liczba+ ":");
            liczba = liczba / i;
            System.out.println(i);
            i++;



        }

        }


    }
    }





