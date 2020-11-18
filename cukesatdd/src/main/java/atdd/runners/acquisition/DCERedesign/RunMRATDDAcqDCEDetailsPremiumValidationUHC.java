package atdd.runners.acquisition.DCERedesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEDetailsPremiumValidationUHC - Scenario to validate MS$0 and Range Premium validations for DCE Details and Summary pages
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEDetailsPremiumValidationUHC.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDetailsPremiumValidationUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDetailsPremiumValidationUHC.json" }, tags = { "@RunMRATDDAcqDCEDetailsPremiumValidationUHC" })

public class RunMRATDDAcqDCEDetailsPremiumValidationUHC {
//,@DCE_DrugDetailsValidation_AARP, @DCE_DrugDetailsPremiumValidation_AARP
}