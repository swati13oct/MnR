package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEDrugSummaryMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEDrugSummaryMobile.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEDrugSummaryMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, monochrome = true, features = {
		"src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionDCEDrugSummaryMobile.json" }, tags = {
						"@dce_redesign_Drug_summary_AARP", "@F426576",
						"@DCE_DrugSummary_ValidatePage_AARP" }, dryRun = false)

public class RunMRATDDAcquisitionDCEDrugSummaryMobile {

}
// "@dce_redesign_Drug_summary_AARP",
// "@F426576","@DCE_DrugSummary_ValidatePage_AARP"