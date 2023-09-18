package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//you decide what class you will run
@CucumberOptions(//it is a special annotation that have some keywords
        features = "src/test/resources/features/weborder", //this is the location of features file(Content Root)
        glue ="com/test/weborder/stepdefinitions",//this is the location of step def classes
        dryRun = false,
        tags = "@regression",
        plugin ={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class WebOrderRunner {
}
