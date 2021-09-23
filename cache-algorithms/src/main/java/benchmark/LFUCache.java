package benchmark;


import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;



public class LFUCache {
    private static final int DEFAULT_MAX_SIZE = 3;
    private int capacity = DEFAULT_MAX_SIZE;
    private final Map<Integer, HitRate> cache = new HashMap<Integer, HitRate>();
    private final Map<Integer, String> KV = new HashMap<Integer, String>();
    private static final Logger log = Logger.getLogger(LRUCache.class);


    String removeLine;
    public int countRemoved=0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }


    public void set(int key, String value) {
        String v = KV.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                Integer k = getKickedKey();
                 removeLine=KV.get(k);
                log.info("LFU CACHE: DELETED "+removeLine);
                KV.remove(k);
                cache.remove(k);
                countRemoved++;
            }
            long startTimeNano = System.nanoTime();
            cache.put(key, new HitRate(key, 1, System.nanoTime()));
            long endTimeNano = System.nanoTime();
            String timeAdding=String.valueOf(endTimeNano-startTimeNano);
            log.info("LFU CACHE: TOOK "+timeAdding+" ms to add element");
        } else {
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
        }
        KV.put(key, value);
    }

    public String get(int key) {
        String v = KV.get(key);
        if (v != null) {
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
            return v;
        }
        return removeLine+" was deleted";
    }

    // @return the key to be replaced
    private Integer getKickedKey() {
        HitRate min = Collections.min(cache.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {
        Integer key;
        Integer hitCount; // Number of hits
        Long lastTime; // Last hit time

        public HitRate(Integer key, Integer hitCount, Long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        public int compareTo(HitRate o) {
            int hr = hitCount.compareTo(o.hitCount);
            return hr != 0 ? hr : lastTime.compareTo(o.lastTime);
        }
    }

    public  void getCountRemoved(){

        System.out.println("There were removed "+countRemoved+" elements");
        log.info("LFU CACHE: There were removed "+countRemoved+" elements");
    }

    public static void main(String[] as) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.set(2, "2");
        lfuCache.set(1, "1");

        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));

        lfuCache.set(3, "3");
        lfuCache.set(4, "4");

        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(4));

        lfuCache.getCountRemoved();

    }
}