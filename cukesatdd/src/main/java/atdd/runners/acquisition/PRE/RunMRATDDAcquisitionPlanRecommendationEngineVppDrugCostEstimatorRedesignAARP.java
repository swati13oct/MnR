package atdd.runners.acquisition.PRE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run E2E testing on PRE-VPP-DCE using RunMRATDDAcquisitionPlanRecommendationEngineVppDrugCostEstimatorRedesignAARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=2,
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineVppDrugCostEstimatorRedesignAARP.json",
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target/RunMRATDDAcquisitionPlanRecommendationEngineVppDrugCostEstimatorRedesignAARP")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition" },
		features = { "src/main/resources/feature/acquisition" },
		plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineVppDrugCostEstimatorRedesignAARP.json" },
		tags = { "@PRE_VPP_DCE_E2E_AARP" })

public class RunMRATDDAcquisitionPlanRecommendationEngineVppDrugCostEstimatorRedesignAARP {

}
