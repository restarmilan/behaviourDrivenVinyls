package com.rmilan.behaviourDrivenVinyls.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@smoke and @fast",
        glue = {"com.rmilan.behaviourDrivenVinyls.stepDefinitions"})
public class RunCucumberTest {
}
