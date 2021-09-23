package com.epam.ld.module2.testing.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "com.epam.ld.module2.testing.cucumber",
        features = "src/test/resources"
)

public class CucumberTest {
}
