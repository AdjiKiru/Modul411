package ab7_sort;

import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        //int[] liste = {0,9,4,6,2,8,5,1,7,3};
        //int[] liste = {0,1,2,3,4,6,5,7,8,9};
        int[] liste = createArray(10);
        long start = System.currentTimeMillis();
        System.out.println("Unsorted array");
        //printArray(liste);
        //bubblesort(liste);
        //bubblesort2(liste);
        bubblesortMegaThron(liste);
        //insertionsort(liste);
        //quickSort(liste, 0, 99999);
        System.out.println("Sorted array");
        System.out.println(System.currentTimeMillis() - start);
        //printArray(liste);
    }

    public static int[] createArray(int number){
        Random rd = new Random();
        int[] array = new int[number];
        for(int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(1000);
        }
        return array;
    }

    public static void bubblesort(int[] liste){
        int n = liste.length;
        for(int i = 0; i < n-1; i++){
            if(liste[i] > liste[i + 1]){
                System.out.println("CHANGE");
                int temp = liste[i];
                liste[i] = liste[i + 1];
                liste[i + 1] = temp;
                i = -1;
            }
        }
    }

    public static void bubblesort2(int[] liste){
        int n = liste.length;
        int max = (n-1) * (n/2);
        for(int i=0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(liste[j] > liste[j + 1]){
                    int temp = liste[j];
                    liste[j] = liste[j+1];
                    liste[j+1] = temp;
                }
            }
        }
    }

    public static void bubblesortMegaThron(int[] liste){
        int n = liste.length;
        boolean switched;
        int changes = 0;
        for(int i=0; i < n-1; i++){
            switched = false;
            for(int j = 0; j < n-i-1; j++){
                if(liste[j] > liste[j + 1]){
                    changes++;
                    int temp = liste[j];
                    liste[j] = liste[j+1];
                    liste[j+1] = temp;
                    switched = true;
                }
            }
            if(switched == false){
                break;
            }
        }
        System.out.println("Changes: " + changes);
    }

    public static void insertionsort(int[] liste){
        int n = liste.length;
        int changes = 0;
        for (int i = 1; i < n; ++i) {
            int key = liste[i];
            int j = i - 1;
            while (j >= 0 && liste[j] > key) {
                changes++;
                liste[j + 1] = liste[j];
                j = j - 1;
            }
            liste[j + 1] = key;
        }
        System.out.println("Changes: " + changes);
    }

    public static void selectionSort(int[] liste){
        for(int i = 0; i < liste.length - 1; i++){
            int index = 1;
            for (int j = i + 1; j < liste.length; j++){
                if(liste[j] < liste[index]){
                    index = j; //Searching for lowest index
                }
            }
            int smallerNumber = liste[index];
            liste[index] = liste[i];
            liste[i] = smallerNumber;
        }
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}