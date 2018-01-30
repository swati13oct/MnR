package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDSauceLabs
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDFixedTests15.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDFixedTests15")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.saucelabs" }, features = { "src/main/resources/feature/saucelabs" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSauceLabs.json" }, tags = { "@ssllabs" })
public class RunMRATDDSauceLabs {

}
