package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.testkru.tests",
        tags = "@TextFields",
        plugin = {
                "pretty",
                "html:target/testkru-textfields-report.html",
                "json:target/testkru-textfields.json"
        },
        monochrome = true
)
public class TestKruTextFieldsRunner extends AbstractTestNGCucumberTests {

}