package atdd.runners.mobile.prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionVPPPlanSummaryMobileProd
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProd.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanSummaryMobileProd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp/" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProd.json" }, tags = {
						"@prod","@vppPlanSummaryUHCRegression" })
public class RunMRATDDAcquisitionVPPPlanSummaryMobileProd {

}
