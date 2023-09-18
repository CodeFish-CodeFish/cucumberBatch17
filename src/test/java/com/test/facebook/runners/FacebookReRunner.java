package com.test.facebook.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "com/test/facebook/stepdefinitions",
        plugin ={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)

public class FacebookReRunner {
}
