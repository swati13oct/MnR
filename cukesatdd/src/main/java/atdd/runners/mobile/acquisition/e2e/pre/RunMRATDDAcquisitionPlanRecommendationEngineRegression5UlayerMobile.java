package atdd.runners.mobile.acquisition.e2e.pre;

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
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression5UlayerMobile.json",
		detailedReport = true, 
		detailedAggregatedReport = true, 
		overviewReport = true, 
		toPDF = true, 
		outputFolder = "target/RunMRATDDAcquisitionPlanRecommendationEngineRegression5UlayerMobile")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.mobile" }, 
		features = { "src/main/resources/feature/mobile/acquisition/preE2E" }, 
		plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineRegression5UlayerMobile.json" }, 
		tags = {"@PRERegression5"}, dryRun=false)
public class RunMRATDDAcquisitionPlanRecommendationEngineRegression5UlayerMobile {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC