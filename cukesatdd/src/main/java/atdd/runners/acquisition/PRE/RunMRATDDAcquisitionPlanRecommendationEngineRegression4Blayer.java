package atdd.runners.acquisition.PRE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for community Meeting User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=1, 
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression4Blayer.json",
		detailedReport = true, 
		detailedAggregatedReport = true, 
		overviewReport = true, 
		toPDF = true, 
		outputFolder = "target/RunMRATDDAcquisitionPlanRecommendationEngineRegression4Blayer")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition.planRecommendationEngine" }, 
		features = { "src/main/resources/feature/acquisition/PlanRecommendationEngine" }, 
		plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression4Blayer.json" }, 
		tags = {"@PRERegression4"})
public class RunMRATDDAcquisitionPlanRecommendationEngineRegression4Blayer {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC