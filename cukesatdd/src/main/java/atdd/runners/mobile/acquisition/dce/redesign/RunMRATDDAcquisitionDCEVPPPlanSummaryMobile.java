package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * this file is to run test cases for RunMRATDDAcquisitionDCEVPPPlanSummaryMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEVPPPlanSummaryMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEVPPPlanSummaryMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCEVPPPlanSummaryMobile.json" }, tags = { "@DCE_Redesign_VPP_PlanSummary" })


public class RunMRATDDAcquisitionDCEVPPPlanSummaryMobile {

}
