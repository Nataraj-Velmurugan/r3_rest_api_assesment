package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import stepDefinitions.Generics;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"src/test/java/stepDefinitions", "steps", "hooks"},
        tags = "@stage",
        monochrome = true,
        dryRun = false,
        plugin = {
                "json:build/cucumber-reports/cucumber.json",
                "rerun:build/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class TestRunner {

        private static final Logger LOGGER = LogManager.getLogger(Generics.class);

        @Before
        public void beforeScenario() {

                LOGGER.info("Before Method invoked");

        }

}