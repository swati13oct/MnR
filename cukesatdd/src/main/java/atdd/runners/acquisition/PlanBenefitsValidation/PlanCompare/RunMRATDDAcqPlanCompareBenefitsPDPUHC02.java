package atdd.runners.acquisition.PlanBenefitsValidation.PlanCompare;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run plan benefits validations on plan Compare page
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDAcqPlanCompareBenefitsPDPUHC02.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqPlanCompareBenefitsPDPUHC02")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
        features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanCompareBenefitsPDPUHC02.json" }, tags = { "@planCompareBenefitsPDPUHC02" })


public class RunMRATDDAcqPlanCompareBenefitsPDPUHC02 {
}
