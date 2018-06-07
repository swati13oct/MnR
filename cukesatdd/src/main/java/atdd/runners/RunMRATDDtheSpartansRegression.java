package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for spartans team with tag id @theSpartans
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDtheSpartansRegression.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDtheSpartansRegression")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDtheSpartansRegression.json" }, tags = { "@theSpartans" })
public class RunMRATDDtheSpartansRegression {

}
