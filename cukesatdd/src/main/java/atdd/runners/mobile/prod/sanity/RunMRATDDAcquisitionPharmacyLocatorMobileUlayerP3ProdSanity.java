package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP3
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP3.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/pharmacy/PharmacySearch-mobile-spanish.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP3.json" }, tags = { "@prodSanity"})
public class RunMRATDDAcquisitionPharmacyLocatorMobileUlayerP3ProdSanity{ 
 
}
