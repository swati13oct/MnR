package atdd.runners.Prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVisitorProfileUlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionProdVisitorProfileUlayer03.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdVisitorProfileUlayer03")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/visitorProfile/visitorProfile_AARP.feature" }, plugin = { "pretty",
				"html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionProdVisitorProfileUlayer03.json" }, tags = {
						"@prodRegression_AARP_03" })
public class RunMRATDDAcquisitionProdVisitorProfileUlayer03 {

}
