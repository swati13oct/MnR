package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEDetailsPharmacyValidationUHC - Scenario for DCE Details Page pharmacy validation
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDrugSummaryPharmacyValidationsAARP.json" }, tags = { "@dCERedesign_SummaryPage_ChangePharmacy_UHC,@dceRedesignNoPrescriptionChangePharmacy_UHC,@dCERedesign_ChangePharmacyModal_UHC,@dCERedesign_ChangePharmacyNoResults_UHC,@dceRedesignDefaultPharmacyDrugSummary_UHC" })

public class RunMRATDDAcqDCEDrugSummaryPharmacyValidationsUHC {

}
