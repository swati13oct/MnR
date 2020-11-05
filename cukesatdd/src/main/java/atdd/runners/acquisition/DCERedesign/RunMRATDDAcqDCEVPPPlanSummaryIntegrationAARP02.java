package atdd.runners.acquisition.DCERedesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for DCE REdesign - Scenario for VPP Plan Summary Page for MAPD Plans on AARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEVPPPlanSummaryIntegrationAARP02.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEVPPPlanSummaryIntegrationAARP02")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEVPPPlanSummaryIntegrationAARP02.json" }, tags = { "@VPP_NBA_DCE_Redesign_Integration_AARP" })

public class RunMRATDDAcqDCEVPPPlanSummaryIntegrationAARP02 {

}
