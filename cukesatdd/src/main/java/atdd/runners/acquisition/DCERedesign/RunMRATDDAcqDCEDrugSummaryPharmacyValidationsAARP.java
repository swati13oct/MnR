package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCERegressionUlayerHome - Scenario for drug summary Page
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP.json" }, tags = { "@dCERedesign_SummaryPage_ChangePharmacy_AARP,@dceRedesignNoPrescriptionChangePharmacy_AARP,@dCERedesign_ChangePharmacyModal_AARP,@dCERedesign_ChangePharmacyNoResults_AARP,@dceRedesignDefaultPharmacyDrugSummary_AARP" })

public class RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP {

}
