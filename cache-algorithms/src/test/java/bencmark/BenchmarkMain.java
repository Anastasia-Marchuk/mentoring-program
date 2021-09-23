package bencmark;

import benchmark.MergeSortAlgorithm;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import org.junit.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.options.TimeValue;

public class BenchmarkMain {

    @Test
    public void runBenchmarksRecursiveAndIterrativle() throws Exception {

        Options options = new OptionsBuilder()
                .include(JunitSearchAlgorithmTest.class.getSimpleName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.nanoseconds(1))
                .warmupIterations(3)
                .threads(1)
                .measurementIterations(3)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Test
    public void runBenchmarksMergeSort() throws Exception {

        Options options = new OptionsBuilder()
                .include(MergeSortAlgorithm.class.getSimpleName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.nanoseconds(1))
                .warmupIterations(1)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Test
    public void runBenchmarkInsertionSort() throws Exception {

        Options options = new OptionsBuilder()
                .include(JunitInsertionSortTest.class.getSimpleName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.nanoseconds(1))
                .warmupIterations(1)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Test
    public void runBenchmarkBinarySort() throws Exception {

        Options options = new OptionsBuilder()
                .include(JunitBinarySearchTest.class.getSimpleName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.nanoseconds(1))
                .warmupIterations(1)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }
}

