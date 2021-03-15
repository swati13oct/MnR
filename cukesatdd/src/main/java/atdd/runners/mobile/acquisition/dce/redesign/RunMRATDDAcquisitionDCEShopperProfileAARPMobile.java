package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEShopperProfileAARPMobile - Scenario for Shopper Profile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEShopperProfileAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEShopperProfileAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCEShopperProfileAARPMobile.json" }, 
tags = { "@DCEShopperProfileAddDrugsGlobally_AARP, @DCEShopperProfileAddDrugsPlancard_AARP, @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_AARP" }, dryRun=false)

public class RunMRATDDAcquisitionDCEShopperProfileAARPMobile {

}