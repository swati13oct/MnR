package atdd.runners.acquisition.PRE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run E2E testing on PRE-VPP-DCE using RunMRATDDAcquisitionPREDCEVppIntegrationAARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=1,
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPREDCEVppIntegrationAARP.json",
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target/RunMRATDDAcquisitionPREDCEVppIntegrationAARP")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition" },
		features = { "src/main/resources/feature/acquisition/PlanRecommendationEngine" },
		plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPREDCEVppIntegrationAARP.json" },
		tags = { "@PRE_VppPlanSummaryCard_DCE_AARP" })

public class RunMRATDDAcquisitionPREDCEVppIntegrationAARP {

}