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
jsonReport = "target/cucumber-RunMRATDDAcqPlanSummaryBenefitsPDPAARP01NextYear.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqPlanSummaryBenefitsPDPAARP01NextYear")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanSummaryBenefitsPDPAARP01NextYear.json" }, tags = { "@planSummaryBenefitsPDPAARP01_NextYear" })
public class RunMRATDDAcqPlanSummaryBenefitsPDPAARP01NextYear { 

} 