package atdd.runners.mobile.acquisition.siteSearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionProviderSearchUlayerMobileUAT
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProviderSearchUlayerMobileUAT.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProviderSearchUlayerMobileUAT")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/providersearch" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionProviderSearchUlayerMobileUAT.json" }, 
tags = { "@UATRegression" }, dryRun=false)
public class RunMRATDDAcquisitionProviderSearchUlayerMobileUAT { 
 
}
