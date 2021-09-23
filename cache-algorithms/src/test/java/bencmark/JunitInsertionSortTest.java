package bencmark;

import benchmark.InsertionSortAlgorithm;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;


@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Threads(Threads.MAX)
public class JunitInsertionSortTest {

    @Test
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testInsertionSort(){
        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSortAlgorithm isa = new InsertionSortAlgorithm();
        String sortResult=isa.printArray(isa.sort(arr));
        assertEquals("5 6 11 12 13 ",sortResult);

    }
}
