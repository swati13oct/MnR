package atdd.runners.acquisition.PlanBenefitsValidation.PlanSummary.NextYear;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run plan benefits validations on plan Summary page
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcqPlanSummaryBenefits_NextYearAARP04.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqPlanSummaryBenefits_NextYearAARP04")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanSummaryBenefits_NextYearAARP04.json" }, tags = { "@planSummaryBenefitsAARP04_NextYear" })
public class RunMRATDDAcqPlanSummaryBenefits_NextYearAARP04 { 

} 