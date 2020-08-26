package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run Sanity test cases for PRE using RunMRATDDAcquisitionSanityPlanRecommendationEngineUlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=1,
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionSanityPlanRecommendationEngineUlayer.json",
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target/RunMRATDDAcquisitionSanityPlanRecommendationEngineUlayer")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition.planRecommendationEngine" },
		features = { "src/main/resources/feature/acquisition/PlanRecommendationEngine" },
		plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionSanityPlanRecommendationEngineUlayer.json" },
		tags = { "@SanityPRE" })
public class RunMRATDDAcquisitionSanityPlanRecommendationEngineUlayer { 
 
}
