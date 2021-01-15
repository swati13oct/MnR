package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDRegressionAutoRefillSelection.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionAutoRefillSelection")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, features = {
		"src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = { "pretty",
				"html:reports/test-report",
				"json:target/cucumber-RunMRATDDRegressionAutoRefillSelection.json" }, tags = {"@F482464"}, monochrome = true)
public class RunMRATDDRegressionAutoRefillSelection {

}