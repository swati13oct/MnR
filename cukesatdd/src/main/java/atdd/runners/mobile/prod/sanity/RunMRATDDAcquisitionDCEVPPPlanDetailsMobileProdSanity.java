package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionMobileDCEVPPPlanDetails
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEVPPPlanDetailsMobileProdSanity.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEVPPPlanDetailsMobileProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionDCEVPPPlanDetailsMobileProdSanity.json" }, tags = { "@DCE_Redesign_VPP_PlanDetails", "@prodSanity" })

public class RunMRATDDAcquisitionDCEVPPPlanDetailsMobileProdSanity {

}
