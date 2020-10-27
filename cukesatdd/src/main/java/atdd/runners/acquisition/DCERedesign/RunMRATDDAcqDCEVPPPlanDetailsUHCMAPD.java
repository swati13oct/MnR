package atdd.runners.acquisition.DCERedesign;


import org.junit.runner.RunWith;


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for DCE REdesign - Scenario for VPP Plan Details Page for MAPD Plans on UHC
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=1,screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcqDCEVPPPlanDetailsUHCMAPD.json",
		detailedReport = true,
		detailedAggregatedReport = true, 
		overviewReport = true, toPDF = true, 
		outputFolder = "target/RunMRATDDAcqDCEVPPPlanDetailsUHCMAPD")

@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition" }, 
		features = { "src/main/resources/feature/acquisition" }, 
		plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEVPPPlanDetailsUHCMAPD.json" }, 
		tags = { "@DCE_Redesign_VPP_PlanDetails_MAPD_UHC" })

public class RunMRATDDAcqDCEVPPPlanDetailsUHCMAPD {

}
