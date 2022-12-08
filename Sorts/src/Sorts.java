import java.util.Arrays;
import java.util.Random;

/**
 * Kelvin Kemper
 * CS 361
 */

public class Sorts {

    static final int n = 100000; // number of elements to be sorted
    static final int threshold = 44;    // use insertion sort if size <= S

    /**
     * Method is the first part of mergesort where the array is divided recursively into smaller parts
     * before being placed back together in a new array.
     */
    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted subarrays
            merge(arr, left, mid, right);
        }
    }

    /**
     * Second part of merge sort where we combine elemetns of the unsorted array into a sorted state.
     * @param arr input array of random elements
     *
     */
    public void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = Arrays.copyOfRange(arr, l, m + 1);
        int M[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[m + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = l;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position
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

    /**
     * Insertion Sort method
     * Compare key with each element on the left of it until an element smaller than
     * it is found.
     * @param array random array generated in main method
     */
    public void insertionSort(int array[], int left, int right) {
        //iterate through array while checking if j >=0 and current array[i] is less than array[i-1]
        for (int i= 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;

            while (j >= 0 && curr < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = curr;
        }
    }

    /**
     * Prints the sorted array
     * no longer needed, only need for verification that the algorithm actually returns sorted array
     */
    public static void printArray(int arr[]) {
        java.util.Arrays.toString(arr);
    }


    /**
     * combining Merge Sort and Insertion Sort by using code from each
     * @param arr input random element array of size n
     * @param l starting
     * @param r end
     * @param threshold
     */

    public void mergeInsertionSort(int[] arr, int l, int r, int threshold) {
        if (r - l <= threshold) {
            insertionSort(arr, l, r);
        } else {
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid,r);
            merge(arr,l,mid,r);
        }
    }

    /**
     * Tests if the array is actually sorted and throws a print statement if false
     * @param arr input array of current sorting algorithm
     */
    public static void testSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                System.out.println("Sort failed");
                break;
            }
        }
    }

    public static void main(String[] args) {

        //Amount of elements in the array.

        Random rd = new Random(); // creating Random object

        Sorts mergeSort = new Sorts();
        Sorts insertSort = new Sorts();
        Sorts mergeInsertionSort = new Sorts();


        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            // storing random integers in an array
            // same elements being sorted in different arrays to have consistency
            arr1[i] = rd.nextInt();
            arr2[i] = arr1[i];
            arr3[i] = arr1[i];
        }

        System.out.println("Insertion Sort");
        double startTime1 = System.currentTimeMillis();
        insertSort.insertionSort(arr1, 0, arr3.length);
        double elapsedTime1 = System.currentTimeMillis() - startTime1;
        testSort(arr1);
        System.out.println("It took " + elapsedTime1/1000 + " seconds to complete an insertion"
                + " sort of " + arr1.length + " elements\n");


        System.out.println("Merge Sort");
        double startTime2 = System.currentTimeMillis();
        mergeSort.mergeSort(arr2, 0, arr2.length - 1);
        double elapsedTime2 = System.currentTimeMillis() - startTime2;
        printArray(arr2);
        testSort(arr2);
        System.out.println("It took " + elapsedTime2/1000 + " seconds to complete a merge " +
                "sort of " + arr2.length + " elements\n");
        //printArray(arr2);


        System.out.println("Merge-Insertion Sort");
        mergeInsertionSort.mergeInsertionSort(arr3, 0, arr3.length-1, threshold);
        double startTime3 = System.currentTimeMillis();
        mergeSort.mergeSort(arr3, 0, arr3.length - 1);
        double elapsedTime3 = System.currentTimeMillis() - startTime3;
        testSort(arr3);
        System.out.println("It took " + elapsedTime3/1000 + " seconds to complete a merge-insertion" +
                "sort of " + arr3.length + " elements");
        testSort(arr3);
    }
}
