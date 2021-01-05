package atdd.runners.mobile.acquisition.dce.redesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEDetailsStandardCopayAARPMobile - Scenario for DCE Details Page copay section Standard Pharmacy copays validation
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEDetailsStandardCopayAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEDetailsStandardCopayAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCEDetailsStandardCopayAARPMobile.json" }, 
tags = { "@DCE_DrugDetailsCopay_Standard_AARP" }, dryRun=false)

public class RunMRATDDAcquisitionDCEDetailsStandardCopayAARPMobile {
 
}
