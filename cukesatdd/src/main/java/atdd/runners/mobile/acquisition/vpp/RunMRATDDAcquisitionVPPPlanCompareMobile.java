package atdd.runners.mobile.acquisition.vpp;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVPPPlanCompareMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanCompareMobile.json", 
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, 
toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanCompareMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanCompareMobile.json" }, tags = {
						"@vppPlanCompareUHC","@vppPlanCompareUHCRegression" },dryRun=false)
public class RunMRATDDAcquisitionVPPPlanCompareMobile {

}