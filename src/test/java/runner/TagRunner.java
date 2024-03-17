package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.lang.String;

@RunWith(Cucumber.class)
@CucumberOptions
        (
            features = "src/test/java/features/Tags.feature",
            glue = {"steps"},
//            tags = "{@smoke and @regression}"
            // tags = "{@smoke or @regression}"
             //   tags = "{(@smoke or @regression) and @important}"
                tags = "@mustRun"
        )
public class TagRunner {
}
