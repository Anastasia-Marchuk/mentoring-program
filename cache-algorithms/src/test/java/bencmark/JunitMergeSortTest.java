package bencmark;

import benchmark.MergeSortAlgorithm;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Threads(Threads.MAX)
public class JunitMergeSortTest {

    @Test
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testMergeSort(){

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        MergeSortAlgorithm ob = new MergeSortAlgorithm();
        ob.sort(arr);

    }

}
