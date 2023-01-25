package priority;

import java.util.Arrays;

public class MinMaxPriorityQueueImpl<T extends Comparable<? super T>>
        implements MinMaxPriorityQueue<T>{

    private ItemInHeap[] heap;
    private ItemInHeap[] minHeap;

    private int heapSize;
    private int minHeapSize;

    private static int capacity = 1000000;

    public MinMaxPriorityQueueImpl(){
        this.capacity = capacity + 1;

        heap = new ItemInHeap[this.capacity];
        minHeap = new ItemInHeap[this.capacity];

        heapSize = 0;
        minHeapSize = 0;
    }

    public void clear()
    {
        heap = new ItemInHeap[this.capacity];
        minHeap = new ItemInHeap[this.capacity];

        heapSize = 0;
        minHeapSize = 0;
    }

    public ItemInHeap[] getMinHeap(){
        return this.minHeap;
    }

    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    public boolean isMinHeapEmpty(){return minHeapSize == 0;}

    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    public boolean isMinHeapFull(){return minHeapSize == capacity - 1;}
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }

    public int minHeapSize(){
        return minHeapSize;
    }

    /** function to insert task **/
    public void insert(T job, int priority)
    {
        ItemInHeap newJob = new ItemInHeap(job, priority);

        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.getPriority() > heap[pos/2].getPriority())
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;
    }
    public void insertMinHeap(T job, int priority){
        ItemInHeap newJob = new ItemInHeap(job, priority);

        minHeap[++minHeapSize] = newJob;
        int pos = minHeapSize;
        while (pos != 1 && newJob.getMinPriority() > minHeap[pos/2].getMinPriority())
        {
            //this.insertMinHeap(this.minHeap, pos/2+1, minHeap[pos/2]);
            minHeap[pos] = minHeap[pos/2];
            pos /=2;
        }
        minHeap[pos] = newJob;
    }

    private void insertMinHeap(ItemInHeap[] my_array, int Index_position, ItemInHeap newValue){
        for(int i=my_array.length-1; i > Index_position; i--){
            my_array[i] = my_array[i-1];
        }
        my_array[Index_position] = newValue;
    }


    @Override
    public void add(T item, int priority) {
        insert(item, priority);
        insertMinHeap(item, priority);
    }


    @Override
    public T minPriorityItem() {
        int parent, child;
        ItemInHeap item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = minHeap[1];
        temp = minHeap[minHeapSize--];

        parent = 1;
        child = 2;
        while (child <= minHeapSize)
        {
            if (child < minHeapSize && minHeap[child].getMinPriority() < minHeap[child + 1].getMinPriority())
                child++;
            if (temp.getMinPriority() >= minHeap[child].getMinPriority())
                break;

            minHeap[parent] = minHeap[child];
            parent = child;
            child *= 2;
        }
        minHeap[parent] = temp;

        return (T) item.getItem();
    }

    @Override
    public T maxPriorityItem() {
        int parent, child;
        ItemInHeap item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[1];
        temp = heap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].getPriority() < heap[child + 1].getPriority())
                child++;
            if (temp.getPriority() >= heap[child].getPriority())
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return (T) item.getItem();
    }
}
