package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCERegressionUlayerHome - Scenario for VPP Page
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEShopperProfileUHCMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEShopperProfileUHCMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEShopperProfileUHCMobile.json" }, tags = { "@DCEShopperProfileAddDrugsGlobally_UHC, @DCEShopperProfileAddDrugsPlancard_UHC" })

//, @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_UHC - Removing Authenticated flow tag. Will create new runner to separate out
public class RunMRATDDAcqDCEShopperProfileUHCMobile {

}
