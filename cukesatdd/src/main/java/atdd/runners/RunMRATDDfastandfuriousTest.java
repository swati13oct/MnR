package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for fastandfurious team with tag id @fastandfurious
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDfastandfuriousTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDfastandfuriousTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDfastandfuriousTest.json" }, tags = { "@F296012,@RevertF282564"})
public class RunMRATDDfastandfuriousTest {

	//@F296012 - Pre-Effective TFN
	//@F282564 - Group Secure Messaging
	//@RevertF282564 - Revert Secure Email for CalPERS, Texas ERS and GA DCH
}