package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesign.registration" }, features = { "src/main/resources/feature/memberrdesign/registration" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-SanityRunRedesignRegistration.json" }, tags = { "@smokeTest_registrationRedesign" },monochrome = true)

public class SanityRunRedesignRegistration {

}
