
import java.util.SplittableRandom;

/** Class D-ary Heap **/
class DaryHeap {
    public static int d = 3; // d in d-ary
    public static int n = 15; // number of random elements that are being sorted
    private int heapSize;
    private int[] heap;

    /** Constructor **/
    public DaryHeap(int capacity, int numChild) {

        heapSize = 0;
        d = numChild;
        heap = new int[capacity + 1];
    }

  /**  public void sort(int arr[]){
        int nLength = n;
        for (int i = 0; i < ; i++) {

        };

    }*/

    /** Function to  get index parent of i **/
    private int parent(int i) {
        return (i - 1)/d;
    }

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    /** Function to insert element */
    public void insert(int x) {
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    /** Function to find least element **/
    public int extractMin( ) {
        return heap[0];
    }


    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    /** Function heapifyDown **/
    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    /** Function to get smallest child **/
    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize))
        {
            if (heap[pos] < heap[bestChild])
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }

    public static void main(String[] args) {
        DaryHeap dh = new DaryHeap(n,d);
        SplittableRandom random = new SplittableRandom();


        for (int i = 0; i < n; i++) {
            dh.insert(random.nextInt(0,n));
        }
        dh.printHeap();


    }
}



