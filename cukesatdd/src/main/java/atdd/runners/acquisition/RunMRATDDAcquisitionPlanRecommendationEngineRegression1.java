package atdd.runners.acquisition;

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
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression1.json",
		detailedReport = true, 
		detailedAggregatedReport = true, 
		overviewReport = true, 
		toPDF = true, 
		outputFolder = "target/RunMRATDDAcquisitionPlanRecommendationEngineRegression1")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition.planRecommendationEngine" }, 
		features = { "src/main/resources/feature/acquisition/PlanRecommendationEngine" }, 
		plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression1.json" }, 
		tags = {"@PRERegression1"})
public class RunMRATDDAcquisitionPlanRecommendationEngineRegression1 {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC