package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionVppPlanSummaryNextBestActionModal
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcqusitionVPPNextActionModalShopFlowAARP.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqusitionVPPNextActionModalShopFlowAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp/NextBestActionModal.feature" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcqusitionVPPNextActionModalShopFlowAARP.json" }, tags = { "@dce_NBA_ShopPagesPDP_UHC" })

public class RunMRATDDAcqusitionVPPNextActionModalShopFlowAARP {

}
