package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCENBAValidationsAARPMobile - Scenario for NBA validations on drug summary Page and details page
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionDCENBAValidationsAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCENBAValidationsAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, 
features = { "src/main/resources/feature/mobile/acquisition/dceredesign" },  plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDCENBAValidationsAARPMobile.json" }, 
tags = { "@dceNBADrugSummaryPage_AARP,@dceNBADetailPageNBA_MAPD_AARP,@dceNBADetailPageNBA_PDP_AARP,@dceNBADetailPageNBA_SNP_AARP" }, dryRun=false)
public class RunMRATDDAcquisitionDCENBAValidationsAARPMobile {

}
