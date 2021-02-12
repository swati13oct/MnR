package atdd.runners.mobile.acquisition.pharmacy;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP9
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP9.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP9")
@CucumberOptions(glue = { "atdd.framework","acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/pharmacy/PharmacySearch-mobile.feature" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPharmacyLocatorUlayerP9.json" }, 
tags = { "@pharmacylocatorulayer07" })
public class RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP9{ 
 
}
