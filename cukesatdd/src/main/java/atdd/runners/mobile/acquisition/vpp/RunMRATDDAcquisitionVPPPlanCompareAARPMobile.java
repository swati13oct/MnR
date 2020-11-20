package atdd.runners.mobile.acquisition.vpp;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVPPPlanCompareAARPMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanCompareAARPMobile.json", 
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, 
toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanCompareAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanCompareAARPMobile.json" }, tags = {
						"@vppPlanCompareAARPNew","@vppPlanCompareAARPRegression" },dryRun=false)
public class RunMRATDDAcquisitionVPPPlanCompareAARPMobile {

}