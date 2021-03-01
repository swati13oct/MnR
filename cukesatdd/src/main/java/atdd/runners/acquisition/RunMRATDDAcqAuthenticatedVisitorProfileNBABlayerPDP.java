package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcqAuthenticatedVisitorProfileNBABlayerPDP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcqAuthenticatedVisitorProfileNBABlayerPDP.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqAuthenticatedVisitorProfileNBABlayerPDP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/visitorProfile" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcqAuthenticatedVisitorProfileNBABlayerPDP.json" }, tags = {
						"@authenticatedNBAPDPUHC02" })
public class RunMRATDDAcqAuthenticatedVisitorProfileNBABlayerPDP {

}
