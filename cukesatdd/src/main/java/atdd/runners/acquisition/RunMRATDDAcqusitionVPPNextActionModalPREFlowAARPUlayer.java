package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionVppPlanSummaryNextBestActionModal
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcqusitionVPPNextActionModalPREFlowAARPUlayer.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqusitionVPPNextActionModalPREFlowAARPUlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp/NextBestActionModal.feature" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcqusitionVPPNextActionModalPREFlowAARPUlayer.json" }, tags = { "@NBA_PRE_AARP01" })

public class RunMRATDDAcqusitionVPPNextActionModalPREFlowAARPUlayer {

}