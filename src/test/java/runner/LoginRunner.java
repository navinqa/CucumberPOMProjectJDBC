package runner;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/LoginDemo.feature",
        monochrome = true,
        glue = {"steps"},
        plugin = {"pretty", "html:target/LoginReport.html"})
public class LoginRunner {
}
