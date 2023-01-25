import org.junit.Test;
import priority.ItemInHeap;
import priority.MinMaxPriorityQueue;
import priority.MinMaxPriorityQueueImpl;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestMinMaxQ {
    @Test
    public void testAdd(){
        MinMaxPriorityQueue q = new MinMaxPriorityQueueImpl();
        q.add(1, 0);
        q.add(2, 2);
        q.add(4, 2);
        q.add(3, 1);
        q.add(5, 3);

        //for (int i = 0; i < 6; i++){
        //                    if (q.getMinHeap()[i] != null){
        //                                System.out.println(q.getMinHeap()[i].getItem());
        //                    }
        //        }
        //        System.exit(0);

        System.out.println(q.minPriorityItem());
        System.out.println(q.minPriorityItem());
        System.out.println(q.minPriorityItem());
        System.out.println(q.minPriorityItem());
        System.out.println(q.minPriorityItem());
    }
}
