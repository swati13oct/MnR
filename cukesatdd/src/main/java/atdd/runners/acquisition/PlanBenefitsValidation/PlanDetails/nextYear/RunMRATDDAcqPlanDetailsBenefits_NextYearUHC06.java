package atdd.runners.acquisition.PlanBenefitsValidation.PlanDetails.nextYear;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run plan benefits validations on plan details page
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcqPlanDetailsBenefits_NextYearUHC06.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqPlanDetailsBenefits_NextYearUHC06")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanDetailsBenefits_NextYearUHC06.json" }, tags = { "@planDetailsBenefitsUHC06_NextYear" })
public class RunMRATDDAcqPlanDetailsBenefits_NextYearUHC06 { 

} 