package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "junit:target/junit.xml",
                "html:target/cluecumber-report-html/index.html",
                "json:target/cluecumber-report-json/cucumber.json"
        },
        features = "classpath:features",
        glue = {"steps"},
        tags = "@Regressivo",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        publish = true,
        dryRun = false
)

public class RunTest extends AbstractTestNGCucumberTests {

}
