package atdd.runners.acquisition.PRE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run E2E testing on PRE-VPP-DCE using RunMRATDDAcquisitionPREDCEVppIntegrationUHC
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount=1,
		screenShotSize="", 
		screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDAcquisitionPREDCEVppIntegrationUHC.json",
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		toPDF = true,
		outputFolder = "target/RunMRATDDAcquisitionPREDCEVppIntegrationUHC")
@CucumberOptions(
		glue = { "atdd.framework", "acceptancetests.acquisition" },
		features = { "src/main/resources/feature/acquisition" },
		plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPREDCEVppIntegrationUHC.json" },
		tags = { "@PRE_VppPlanSummaryCard_DCE_UHC" })

public class RunMRATDDAcquisitionPREDCEVppIntegrationUHC {

}
