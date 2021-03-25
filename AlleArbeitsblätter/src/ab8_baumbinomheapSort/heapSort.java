package ab8_baumbinomheapSort;
public class heapSort {

    public static void main(String[] args) {
        int[] zahlen = {16,14,10,8,7,9,3,2,4,1};
        heapSort ob = new heapSort();
        ob.heapsort(zahlen);
        printArray(zahlen);
    }
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
    public static void heapsort(int[] A){
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i-- ){
            maxHeapify(A, n, i);
        }
        for (int i = n - 1; i > 0; i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            maxHeapify(A, i, 0);
        }
    }

    public static void maxHeapify(int[] A, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < n && A[l] > A[largest]){
            largest = l;
        }
        if(r < n && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;
            maxHeapify(A, n, largest);
        }
    }

}