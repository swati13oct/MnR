package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionFooterAARPMobileProSanity
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionFooterAARPMobileProSanity.json",detailedReport = true,
detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionFooterAARPMobileProSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/globalComponents" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionFooterAARPMobileProSanity.json" }, 
tags = { "@globalfooter_AARP" }, dryRun=false)
public class RunMRATDDAcquisitionFooterAARPMobileProSanity {

}
//@globalfooter_AARP