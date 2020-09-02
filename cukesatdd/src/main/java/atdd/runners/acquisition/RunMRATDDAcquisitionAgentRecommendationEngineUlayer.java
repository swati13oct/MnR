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
		jsonReport = "target/cucumber-RunMRATDDAcquisitionAgentRecommendationEngineUlayer.json",
		detailedReport = true, 
		detailedAggregatedReport = true, 
		overviewReport = true, 
		toPDF = true, 
		outputFolder = "target/RunMRATDDAcquisitionAgentRecommendationEngineUlayer")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition.agentRecommendationEngine" }, 
		features = { "src/main/resources/feature/acquisition/agentRecommendationEngine" }, 
		plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionAgentRecommendationEngineUlayer.json" }, 
<<<<<<< HEAD
		tags = {"@PlanYearAutoRanking"})
=======
		tags = {})
>>>>>>> 1eab26e369815208a295cef83c78cce084dc34a2
public class RunMRATDDAcquisitionAgentRecommendationEngineUlayer {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC