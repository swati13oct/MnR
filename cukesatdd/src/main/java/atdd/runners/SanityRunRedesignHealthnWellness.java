package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesign.healthandwellness" }, features = { "src/main/resources/feature/memberrdesign/health-and-wellness" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-SanityRunRedesignHealthnWellness.json" }, tags = { "@smokeTest__H&W" }, monochrome = true)

public class SanityRunRedesignHealthnWellness {

}
