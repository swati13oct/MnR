package atdd.runners.acquisition.PlanBenefitsValidation.PlanDetails;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run plan benefits validations on plan details page
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcqPlanDetailsBenefitsAARP08.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqPlanDetailsBenefitsAARP08")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanDetailsBenefitsAARP08.json" }, tags = { "@planDetailsBenefitsAARP08" })
public class RunMRATDDAcqPlanDetailsBenefitsAARP08 { 

} 