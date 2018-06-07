package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for codeMonkeys with tag id @codeMonkeys
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDcodeTransformersRegression.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDcodeTransformersRegression")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDcodeTransformersRegression.json" }, tags = {"@regression_sso,@regression_branding"})
public class RunMRATDDcodeTransformersRegression {

}
