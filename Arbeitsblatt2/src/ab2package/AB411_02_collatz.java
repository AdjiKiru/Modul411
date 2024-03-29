//  @author:       Ralph.Maurer@iet-gibb.ch
//  Compilation:   javac AB411_01_Collatz.java
//  Execution:     java -jar AB411_01_Collatz.jar
//
//  Print the collatz sequence of n.
//
//  % Example Collatz 6
//  6 3 10 5 16 8 4 2 1
//
//  % Example Collatz 27
//  27 82 41 124 62 31 94 47 142 71 214 107 322 161 484 242 121 364 182
//  91 274 137 412 206 103 310 155 466 233 700 350 175 526 263 790 395
//  1186 593 1780 890 445 1336 668 334 167 502 251 754 377 1132 566 283
//  850 425 1276 638 319 958 479 1438 719 2158 1079 3238 1619 4858 2429
//  7288 3644 1822 911 2734 1367 4102 2051 6154 3077 9232 4616 2308
//  1154 577 1732 866 433 1300 650 325 976 488 244 122 61 184 92 46 23
//  70 35 106 53 160 80 40 20 10 5 16 8 4 2 1
//
//  % Example Collatz 35
//  35 106 53 160 80 40 20 10 5 16 8 4 2 1
//
//  % Example Collatz 256
//  256 128 64 32 16 8 4 2 1

package ab2package;
import java.io.*;

public class AB411_02_collatz {

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
