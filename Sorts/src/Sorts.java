import java.util.Random;


public class Sorts {

    public void merge(int arr[], int p, int q, int r) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    public void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }

    // Print the array
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program

    public static void main(String[] args) {

        //Amount of elements in the array.
        int n = 100;

        Random rd = new Random(); // creating Random object
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        Sorts mergeSort = new Sorts();
        Sorts insertSort = new Sorts();

        System.out.println("MergeSort");
        double startTime = System.currentTimeMillis();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        double elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("It took " + elapsedTime + " milliseconds to complete a merge " +
                 "sort of " + arr.length + " elements");

        int[] arr2 = new int[n];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rd.nextInt(); // storing random integers in an array
        }
        double startTime2 = System.currentTimeMillis();
        insertSort.insertionSort(arr2);
        double elapsedTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("It took " + elapsedTime2 + " milliseconds to complete an insertion"
                + " sort of " + arr2.length + " elements");
        //printArray(arr2);
    }



}
