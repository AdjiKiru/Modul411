package ab2_collatz;
import java.io.*;

public class AB411_02_Collatz {

    public static void collatz_procedure(long n){
        while (n > 1)
        { if (n % 2 == 0)
        {
            System.out.print((n / 2) + " ");
            n = n / 2;
        }
        else
        {
            System.out.print((3*n + 1) + " ");
            n = 3 * n + 1;
        }
        }
    }
    public static void main(String[] args) throws java.io.IOException {
        String eingabe;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eingabe:");
        eingabe = input.readLine();
        long n = Long.parseLong(eingabe);
        System.out.println("Collatz-Berechnung für: " + eingabe);
        System.out.println("Prozedurale Berechnung:");
        collatz_procedure(n);
    }

}