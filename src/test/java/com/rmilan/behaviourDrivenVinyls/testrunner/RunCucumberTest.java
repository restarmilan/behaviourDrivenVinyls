package com.rmilan.behaviourDrivenVinyls.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin = {"pretty"},
        snippets = SnippetType.CAMELCASE,
        tags = "@smoke and @fast",
        glue = {"com.rmilan.behaviourDrivenVinyls.stepDefinitions"})
public class RunCucumberTest {
}
