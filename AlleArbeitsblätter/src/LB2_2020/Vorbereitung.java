package LB2_2020;

public class Vorbereitung {
    public static int nachbarn(int[][] Welt) {
        int anzahl = 0;
        if (Welt.length == 3){
            if (Welt[0].length == 3 && Welt[1].length == 3 && Welt[2].length == 3){
                for (int i = 0; i < Welt.length; i++){
                    for (int j = 0; j < Welt[i].length; j++){
                        if (Welt[i][j] == 1){
                            if (i == 1 && j == 1){
                            }else{
                                anzahl++;
                            }
                        }
                    }
                }
                return anzahl;
            }
        }
        return  -1;
    }
    public static void bubblesort(int[] liste) {
        int n = liste.length;
        boolean switched = true;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++) {
                switched = false;
                if (liste[j] > liste[j + 1]) {
                    int temp = liste[j];
                    liste[j] = liste[j + 1];
                    liste[j + 1] = temp;
                    switched = true;
                }
            }
            if(switched == false){
                break;
            }
        }
    }
    public static int binom(int n, int k) {
        double n1 = (double) n;
        double k1 = (double) k;
        if(k1 == 0){
            return 1;
        }else if (2*k1 > n1){
            return binom((int)n1, (int)n1-k);
        }
        return (int) ((n1+1-k1)/k1*binom((int)n1,(int)k1-1));
    }
    public static boolean isMaxHeap(int[] arr) {
        int N = arr.length;
        for (int i = (N - 2) / 2; i > -1; --i) { // start from the first internal node who has children;
            int j = 2 * i + 1; // the left child;
            if (j < N - 1 && arr[i] < arr[j+1]) j++; // select the bigger child;
            if (arr[i] < arr[j]) return false; // if parent is smaller than the child;
        }
        return true;
    }
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("LB2-Uebung M411");
        System.out.println("Nachbarn w1: " + nachbarn(welt_1));
        System.out.println("Nachbarn w2: " + nachbarn(welt_2));
        bubblesort(feld);
        System.out.println("Bubble: " + feld[3] + feld[4]);
        System.out.println("Binom: " + binom(5, 2));
        System.out.println("Binom: " + binom(4, 2));
        System.out.println("h1: " + isMaxHeap(h_1));
        System.out.println("h2: " + isMaxHeap(h_2));
    }
    private static int[][] welt_1 = {{1, 0, 0}, {1, 1, 0}, {0, 0, 1}};
    private static int[][] welt_2 = {{0, 0, 0}, {0, 0, 0}};
    private static int[] feld = {2, 34, 12, 6, 99, 2};
    private static int[] h_1 = {20, 8, 11, 8, 9, 9, 10, 2};

    private static int[] h_2 = {20, 8, 11, 8};
}