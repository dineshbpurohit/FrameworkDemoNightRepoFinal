package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin={"html:target/cucumber_report.html","pretty"},
        features="src/test/java/features",
        glue="stepdefinations"
)
public class Runner extends AbstractTestNGCucumberTests{

}
