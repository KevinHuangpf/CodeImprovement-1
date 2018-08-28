import java.util.*;

public class MyQueue {
    public static void main(String args[]){
        PriorityQueue pq = new PriorityQueue();
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        pq.offer(6);
        System.out.println(pq);

        ArrayDeque queue1 = new ArrayDeque();
        queue1.offer(1);
        queue1.offer(2);
        System.out.println(queue1);

        ArrayDeque queue2 = new ArrayDeque();
        queue2.offerLast(1);
        queue2.offerLast(2);
        System.out.println(queue2);

        ArrayDeque queue3 = new ArrayDeque();
        queue3.offerFirst(1);
        queue3.offerFirst(2);
        System.out.println(queue3);
        LinkedList linkedList  = new LinkedList();
        Map map = new Hashtable();
        map.put(1,null);

    }
}
