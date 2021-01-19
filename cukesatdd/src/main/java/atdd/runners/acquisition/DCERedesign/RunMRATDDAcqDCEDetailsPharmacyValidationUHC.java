package atdd.runners.acquisition.DCERedesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEDetailsPreferredCopayAARP - Scenario for DCE Details Page copay section Preferred Pharmacy copays validation
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEDetailsPharmacyValidationUHC.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDetailsPharmacyValidationUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDetailsPharmacyValidationUHC.json" }, tags = { "@dceRedesignDrugDetailsDefaultPharmacy_MAPD_UHC, @drugDetailschangePharmacyUHC,@editPharmacyFromVPPDetail_UHC,@dCERedesign_ChangePharmacy_DetailsPage,@dCERedesign_ChangePharmacy_DetailsPage_AARP" })

public class RunMRATDDAcqDCEDetailsPharmacyValidationUHC {
 
}
