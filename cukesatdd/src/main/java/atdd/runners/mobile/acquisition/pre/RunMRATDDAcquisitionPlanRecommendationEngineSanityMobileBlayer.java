package atdd.runners.mobile.acquisition.pre;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for community Meeting User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineSanityMobileBlayer.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPlanRecommendationEngineSanityMobileBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition.planrecommendationengine" }, features = { "src/main/resources/feature/mobile/acquisition/planrecommendationengine/"}, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngineSanityMobileBlayer.json" }, 
tags = {"@PDPdrugmobile"})
public class RunMRATDDAcquisitionPlanRecommendationEngineSanityMobileBlayer {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC
