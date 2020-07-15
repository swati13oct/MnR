package atdd.runners.mobile.acquisition.PRE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for community Meeting User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPRESanityMobileBlayer.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPRESanityMobileBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/planrecommendationengine/"}, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPRESanityMobileBlayer.json" }, 
tags = {"@PRESanityMobile"})
public class RunMRATDDAcquisitionPlanRecommendationEngineSanityMobileBlayer {

}


//note: these tags are for  
	//	@Community_Meeting_AARP @Community_Meeting_UHC