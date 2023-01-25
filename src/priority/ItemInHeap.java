package priority;

import javax.security.auth.Subject;

public class ItemInHeap<T> implements Comparable<ItemInHeap>{
    private T item;
    private int priority;
    private int minPriority;

    public ItemInHeap(T item, int priority){
        this.item = item;
        this.priority = priority;
        this.minPriority = -1 * priority;
    }

    public T getItem() {
        return this.item;
    }
    public int getMinPriority(){return this.minPriority;}
    public int getPriority(){
        return this.priority;
    }


    @Override
    public int compareTo(ItemInHeap o) {
        if (this.getPriority() > o.getPriority()){
            return 1;
        }else if (this.getPriority() == o.getPriority()){
            return 0;
        }else{
            return -1;
        }
    }
}
