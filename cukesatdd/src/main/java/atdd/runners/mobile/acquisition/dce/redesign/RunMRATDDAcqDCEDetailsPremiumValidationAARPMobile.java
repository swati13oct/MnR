package atdd.runners.mobile.acquisition.dce.redesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEDetailsPremiumValidationAARP - Scenario to validate MS$0 and Range Premium validations for DCE Details and Summary pages
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcqDCEDetailsPremiumValidationAARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDetailsPremiumValidationAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDetailsPremiumValidationAARP.json" }, 
tags = { "@DCE_DrugDetailsPremiumValidation_AARP" }, dryRun=false)

public class RunMRATDDAcqDCEDetailsPremiumValidationAARPMobile {
//,@DCE_DrugDetailsValidation_AARP, @DCE_DrugDetailsPremiumValidation_AARP
}
