package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionVPPPlanSummaryMobileProd
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanity.json", detailedReport = true, 
detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp/" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanity.json" }, tags = {  "@vppPlanSummaryAARP", "@OnlyProd"})
public class RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanity {

}
//"@vppPlanSummaryAARP", "@OnlyProd" "@ATAT"