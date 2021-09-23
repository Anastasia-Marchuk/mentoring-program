package bencmark;


import benchmark.IterrativelySearch;
import benchmark.RecursivelySearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openjdk.jmh.annotations.*;


import static junit.framework.TestCase.assertEquals;

@State(Scope.Benchmark)
public class JunitSearchAlgorithmTest {

    RecursivelySearch recursivelySearch=new RecursivelySearch();
    IterrativelySearch iterrativelySearch=new IterrativelySearch();

    int [] array = new int[100];

    @Test
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testRecursive(){

        for (int a = 0; a < array.length; a++) {
            array[a] = a + 1;
        }
           long startTimeNano2 = System.currentTimeMillis();
           int indexRecursive=recursivelySearch.runBinarySearch(array, 5,0,99);
           long endTimeNano2 = System.nanoTime();
           System.out.println("index Recursive is "+indexRecursive);
           System.out.println("Total execution time of Recursively binary search:  " + (endTimeNano2-startTimeNano2) + "mms");
           assertEquals(4,indexRecursive);

    }


    @Test
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
       public void testIterrativle( ){

        for (int a = 0; a < array.length; a++) {
            array[a] = a + 1;
        }
          long startTimeNano = System.nanoTime();
            int indexIteratively= iterrativelySearch.runBinarySearch(array, 5,0,99);
            long endTimeNano = System.nanoTime();
           System.out.println("index Iterrative is "+indexIteratively);
           System.out.println("Total execution time of Iteratively binary search:  " + (endTimeNano-startTimeNano) + "mms\n");

         assertEquals(4,indexIteratively);

    }


    @ParameterizedTest
    @DisplayName("This is Parametrized test")
    @ValueSource(ints = {5,2,4})
    void testWithParametrizes(int key) {
        for (int a = 0; a < array.length; a++) {
            array[a] = a + 1;
        }
        long startTimeNano = System.nanoTime();
        int indexIteratively= iterrativelySearch.runBinarySearch(array, key,0,array.length-1);
        long endTimeNano = System.nanoTime();
        System.out.println("index Iterrative is "+indexIteratively);
        System.out.println("Total execution time of Iteratively binary search:  " + (endTimeNano-startTimeNano) + "mms\n");

        assertEquals(key-1,indexIteratively);

    }
}
