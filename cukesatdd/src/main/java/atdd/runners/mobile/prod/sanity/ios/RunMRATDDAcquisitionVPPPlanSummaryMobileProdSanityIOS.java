package atdd.runners.mobile.prod.sanity.ios;

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
jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanityIOS.json", detailedReport = true, 
detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanityIOS")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = {
		"src/main/resources/feature/mobile/acquisition/vpp/" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanityIOS.json" }, tags = { "@ios" })
public class RunMRATDDAcquisitionVPPPlanSummaryMobileProdSanityIOS {

}