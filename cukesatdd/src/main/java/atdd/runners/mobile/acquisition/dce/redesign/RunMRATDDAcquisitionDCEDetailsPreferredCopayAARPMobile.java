package atdd.runners.mobile.acquisition.dce.redesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEDetailsPreferredCopayAARPMobile - Scenario for DCE Details Page copay section Preferred Pharmacy copays validation
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEDetailsPreferredCopayAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
 outputFolder = "target/RunMRATDDAcquisitionDCEDetailsPreferredCopayAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, 
features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCEDetailsPreferredCopayAARPMobile.json" }, 
tags = { "@DCE_DrugDetailsCopay_Preferred_AARP" }, dryRun=false)

public class RunMRATDDAcquisitionDCEDetailsPreferredCopayAARPMobile {
 
}
