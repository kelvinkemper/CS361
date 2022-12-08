import java.util.Arrays;

public class sortTest {
    public void insertion(int[] array) {
        for (int i = 1 ; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }

    }

    public void merge(int arr[], int left, int mid, int right) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i]; //fill L with left half of arr
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j]; // fill R with right half of arr

        // Maintain current index of sub-arrays and main array
        int i, j, indexFillArr;
        i = 0;  //indexes the smallest remaining element of L
        j = 0;  // indexes the smallest remaining element of R
        indexFillArr = left;  // indexes the location in A to fill

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[indexFillArr] = L[i];
                i++;
            } else {
                arr[indexFillArr] = R[j];
                j++;
            }
            indexFillArr++;
        }
        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[indexFillArr] = L[i];
            i++;
            indexFillArr++;
        }

        while (j < n2) {
            arr[indexFillArr] = R[j];
            j++;
            indexFillArr++;
        }
    }

    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            // mid point where the array is divided into two subarrays
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            //NOW WE MERGE
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array){

    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 16, 3, 2, 7, 8, 1};
        int[] arr2 = {10, 5, 16, 3, 2, 7, 8, 1};

        sortTest insert = new sortTest();
        insert.insertion(arr);
        System.out.println(Arrays.toString(arr));

        sortTest merge = new sortTest();
        merge.mergeSort(arr2, 0, arr.length-1);
        System.out.println(Arrays.toString(arr2));

    }
}
