package com.example.stackExchange.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumberReports/badges.html",
                "json:target/cucumberReports/badges.json"
        },
        features = "src/test/resources/cucumber.features/",
        glue = "com.example.stackExchange",
        monochrome = true)
public class TestRunner {

}