package atdd.runners.mobile.acquisition.vpp;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVPPPlanSummaryMobile2
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobile2.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionVPPPlanSummaryMobile2")

@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp/" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobile2.json" }, tags = {
						"@vppPlanSummaryAARP16", "@vppPlanSummaryAARPRun02",
						"@vppPlanSummaryAARPRegression2" }, dryRun = false)
public class RunMRATDDAcquisitionVPPPlanSummaryMobile2 {

}