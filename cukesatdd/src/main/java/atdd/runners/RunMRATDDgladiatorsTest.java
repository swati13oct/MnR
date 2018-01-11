package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for gladiators with tag id @gladiators
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDgladiatorsTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDgladiatorsTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests" }, 
features = { "src/main/resources/feature" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDgladiators.json" }, tags = { "@gladiators" })
public class RunMRATDDgladiatorsTest {

}