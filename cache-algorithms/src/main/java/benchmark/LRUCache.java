package benchmark;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import org.apache.log4j.Logger;


@State(Scope.Thread)
public class LRUCache {

    private static final Logger log = Logger.getLogger(LRUCache.class);

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public int countRemoved=0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) {
            //System.out.println("REMOVED ELEMENT WITH KEY"+key);
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;

    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            countRemoved++;
            log.info("LRU CACHE: DELETED "+head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        long startTimeNano = System.nanoTime();
        Node insert = new Node(key, value);
        hs.put(key, insert);
        //System.out.println("set elemet with key"+key);
        move_to_tail(insert);
        long endTimeNano = System.nanoTime();
        String timeAdding=String.valueOf(endTimeNano-startTimeNano);
        log.info("LRU CACHE: TOOK "+timeAdding+" ms to add element");

    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

    public  void getCountRemoved(){
        System.out.println("There were removed "+countRemoved+" elements");
        log.info("LRU CACHE: There were removed "+countRemoved+" elements");

    }

    public static void main(String[] as)  {
        LRUCache cache = new LRUCache(100000);

        for (int i = 1; i < 100500; i++) {
            cache.set(i, i);
        }

        for (int i = 1; i < 100500; i++) {
            System.out.println(cache.get(i));
        }

//        cache.set(2, 2);
//        cache.set(1, 1);
//
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//
//        cache.set(3, 3);
//        cache.set(4, 4);
//
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//
//        cache.set(5, 5);
//        cache.set(6, 6);
//
//        System.out.println(cache.get(6));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(4));


        cache.getCountRemoved();

    }
}