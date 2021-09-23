package benchmark;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class RecursivelySearch implements BinarySearch{


    public int runBinarySearch(int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearch(
                    sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearch(
                    sortedArray, key, middle + 1, high);
        }
    }

}
