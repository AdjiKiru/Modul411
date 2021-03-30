package tools;

import java.io.IOException;
import java.util.List;

public class Parse {
    public static void printArray(String arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //TODO Auto-generated method stub
        String[] myIntArray = {"13", "05", "2002", "04"};
        System.out.println("Array ausgeben: ");
        printArray(myIntArray);

        //Integer Parser
        System.out.println("Array ParseInt ausgeben: ");
        int parseInt = Integer.parseInt(myIntArray[0]);
        System.out.println(parseInt);

        //Double Parser
        System.out.println("Array ParseDouble ausgeben: ");
        double parseDouble = Double.parseDouble(myIntArray[0]);
        System.out.println(parseDouble);

    }
}