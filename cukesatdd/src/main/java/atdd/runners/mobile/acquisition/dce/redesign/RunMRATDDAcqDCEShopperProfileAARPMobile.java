package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEShopperProfileAARPMobile - Scenario for Shopper Profile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcqDCEShopperProfileAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEShopperProfileAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEShopperProfileAARPMobile.json" }, 
tags = { "@DCEShopperProfileAddDrugsGlobally_AARP, @DCEShopperProfileAddDrugsPlancard_AARP, @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_AARP" }, dryRun=false)

public class RunMRATDDAcqDCEShopperProfileAARPMobile {

}