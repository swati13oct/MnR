package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVppPlanSummary
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcqusitionVPPNextActionModalUlayerPDP02.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqusitionVPPNextActionModalUlayerPDP02")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcqusitionVPPNextActionModalUlayerPDP02.json" }, tags = {
						" @NBA_PDP_AARP02" })

public class RunMRATDDAcqusitionVPPNextActionModalUlayerPDP02 {

}