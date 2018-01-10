package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for upgradedATDD team with tag id @upgradedATDD
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDupgradedATDD.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDupgradedATDD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests" }, 
features = { "src/main/resources/feature" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDupgradedATDD.json" }, tags = { "@upgradedATDD" })
public class RunMRATDDupgradedATDD {

}
