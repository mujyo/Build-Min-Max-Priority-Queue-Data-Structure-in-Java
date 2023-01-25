package priority;

public interface MinMaxPriorityQueue <T>{
    void add(T item, int priority);
    T minPriorityItem();
    T maxPriorityItem();
    //ItemInHeap[] getHeap();
    //int getItemNum();
    ItemInHeap[] getMinHeap();
}
