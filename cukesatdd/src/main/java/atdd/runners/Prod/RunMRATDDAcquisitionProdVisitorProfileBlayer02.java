package atdd.runners.Prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVisitorProfileBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionProdVisitorProfileBlayer02.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdVisitorProfileBlayer02")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/visitorProfile/visitorProfile_UnAuthenticated.feature" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionProdVisitorProfileBlayer02.json" }, tags = {
						"@prodRegression_UHC_02" })
public class RunMRATDDAcquisitionProdVisitorProfileBlayer02 {

}
