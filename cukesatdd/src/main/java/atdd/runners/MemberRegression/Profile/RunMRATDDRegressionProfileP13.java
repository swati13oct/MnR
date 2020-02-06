package atdd.runners.MemberRegression.Profile;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author Tamzid
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionProfileP13.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionProfileP13")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/profileandpreferences/" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionProfileP13.json" }, tags = { "@accountProfile18g" })


public class RunMRATDDRegressionProfileP13 {

}
