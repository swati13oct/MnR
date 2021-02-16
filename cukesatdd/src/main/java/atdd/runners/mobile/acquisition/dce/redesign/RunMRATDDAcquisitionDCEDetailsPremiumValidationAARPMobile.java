package atdd.runners.mobile.acquisition.dce.redesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEDetailsPremiumValidationAARPMobile - Scenario to validate MS$0 and Range Premium validations for DCE Details and Summary pages
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEDetailsPremiumValidationAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEDetailsPremiumValidationAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCEDetailsPremiumValidationAARPMobile.json" }, 
tags = { "@DCE_DrugDetailsPremiumValidation_AARP" }, dryRun=true)

public class RunMRATDDAcquisitionDCEDetailsPremiumValidationAARPMobile {
//,@DCE_DrugDetailsValidation_AARP, @DCE_DrugDetailsPremiumValidation_AARP
}
