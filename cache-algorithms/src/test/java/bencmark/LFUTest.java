package bencmark;

import benchmark.LFUCache;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LFUTest {

    @Test
    public void testLFU(){


        String result="2\n" +
                "1\n" +
                "2\n" +
                "3 was deleted\n" +
                "2\n" +
                "1\n" +
                "4\n";
        assertEquals(result,testGetCache());

    }

    public static String testGetCache(){
        StringBuilder builder=new StringBuilder();

        LFUCache cache = new LFUCache(3);
        cache.set(2, "2");
        cache.set(1, "1");

        //System.out.println(cache.get(2));
        builder.append(cache.get(2)+"\n");
      //  System.out.println(cache.get(1));
        builder.append(cache.get(1)+"\n");
      //  System.out.println(cache.get(2));
        builder.append(cache.get(2)+"\n");

        cache.set(3, "3");
        cache.set(4, "4");

     //   System.out.println(cache.get(3));
        builder.append(cache.get(3)+"\n");

       // System.out.println(cache.get(2));
        builder.append(cache.get(2)+"\n");

     //   System.out.println(cache.get(1));
        builder.append(cache.get(1)+"\n");

    //    System.out.println(cache.get(4));
        builder.append(cache.get(4)+"\n");
        return builder.toString();

    }
}
