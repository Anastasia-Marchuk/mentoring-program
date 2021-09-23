package bencmark;


import benchmark.*;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.Stream;


import static java.lang.String.format;

    class IntegrateTest {

        private BufferedWriter writer;
        BinarySearch binarySearch;
        Random random = new Random();
        Sort sort;


        @BeforeEach
        void writeClass() throws IOException {

            writer = Files.newBufferedWriter(Paths.get("/home/anastasia/EpamMentoringProgram/jmh/README.md"), StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND);
        }

        @ParameterizedTest()
        @MethodSource("test")
        @DisplayName("whenDifferenceImplementations")
        void runBinarySearch_whenDifferenceImplementations(Class<Sort> sortImpl, Class<BinarySearch> searchImpl) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

            int[] arr = new int[100000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100);
            }
            int key = arr[random.nextInt(20000)];

            this.sort = sortImpl.getDeclaredConstructor().newInstance();
            this.binarySearch = searchImpl.getDeclaredConstructor().newInstance();

            Instant start = Instant.now();
            sort.sort(arr);

            int index = binarySearch.runBinarySearch(arr, key, 0, arr.length - 1);
            Instant finish = Instant.now();

            long elapsed = Duration.between(start, finish).toMillis();

            writer.write(format("Test => runBinarySearch_whenDifferenceImplementations => Used sort (%s) and search (%s) index = %d => time spent searching (ms)_%d_\n", sortImpl.getSimpleName(), searchImpl.getSimpleName(),index, elapsed));
            System.out.println((format("Test => runBinarySearch_whenDifferenceImplementations => Used sort (%s) and search (%s) index = %d => time spent searching (ms)_%d_\n", sortImpl.getSimpleName(), searchImpl.getSimpleName(),index, elapsed)));
        }

        private static Stream<Arguments> test() {
            return Stream.of(
                    Arguments.of(InsertionSortAlgorithm.class, IterrativelySearch.class),
                    Arguments.of(MergeSortAlgorithm.class, IterrativelySearch.class),
                    Arguments.of(InsertionSortAlgorithm.class, RecursivelySearch.class),
                    Arguments.of(MergeSortAlgorithm.class, RecursivelySearch.class));
        }

        @AfterEach
        void cleanUp() throws IOException {
            writer.close();
        }
    }