package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEShopperProfileAARP - Scenario for Shopper Profile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEShopperProfileAARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEShopperProfileAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEShopperProfileAARP.json" }, tags = { "@DCEShopperProfileAddDrugsGlobally_AARP, @DCEShopperProfileAddDrugsPlancard_AARP, @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_AARP" })

public class RunMRATDDAcqDCEShopperProfileAARP {

}