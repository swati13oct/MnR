package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run Sanity test cases for PRE using
 * RunMRATDDAcquisitionSanityPlanRecommendationEngineBlayer02
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount = 0,
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionSanityPlanRecommendationEngineBlayer02.json",
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target/RunMRATDDAcquisitionSanityPlanRecommendationEngineBlayer02")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition.planRecommendationEngine" },
		features = {
				"src/main/resources/feature/acquisition/PlanRecommendationEngine/PlanRecommendationEngineBusinessScenarios.feature" },
		plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionSanityPlanRecommendationEngineBlayer02.json" }, tags = {
						"@SanityPRE_02" })
public class RunMRATDDAcquisitionSanityPlanRecommendationEngineBlayer02 {
 
}
