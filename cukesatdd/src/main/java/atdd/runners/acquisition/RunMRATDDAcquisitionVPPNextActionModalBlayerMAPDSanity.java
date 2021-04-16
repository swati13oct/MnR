package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionVppPlanSummaryNextBestActionModal for Sanity and Prod
 * checkout_E2E team
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPNextActionModalBlayerMAPDSanity.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPNextActionModalBlayerMAPDSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp/NextBestActionModal.feature" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPNextActionModalBlayerMAPDSanity.json" }, tags = {
						"@NBA_MAPD_Sanity_UHC" })

public class RunMRATDDAcquisitionVPPNextActionModalBlayerMAPDSanity {

}