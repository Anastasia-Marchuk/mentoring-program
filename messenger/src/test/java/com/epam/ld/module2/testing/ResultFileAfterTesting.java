package com.epam.ld.module2.testing;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.BufferedWriter;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static java.lang.String.format;

public class ResultFileAfterTesting implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        String result = context.getExecutionException().isPresent() ? "FAILED" : "PASSED";
        Optional<Method> testMethod = context.getTestMethod();

        File file = new File("src/test/resources/test_result.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(format("%s\t=>\t%s%n", testMethod, result));
        }
    }
}