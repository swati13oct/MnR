package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for fastandfurious team with tag id @fastandfurious
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDfastandfuriousTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDfastandfuriousTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests" }, 
features = { "src/main/resources/feature" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDfastandfurious.json" }, tags = { "@fastandfurious" })
public class RunMRATDDfastandfuriousTest {

}