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
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPNextActionModalBlayerPDP.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPNextActionModalBlayerPDP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPNextActionModalBlayerPDP.json" }, tags = { "@NBA_PDP_UHC" })
public class RunMRATDDAcquisitionVPPNextActionModalBlayerPDP {

}
