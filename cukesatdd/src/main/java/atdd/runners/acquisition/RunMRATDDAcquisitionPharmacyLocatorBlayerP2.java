package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionPharmacyLocator
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPharmacyLocatorBlayerP2.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPharmacyLocatorBlayerP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator/PharmacySearch-UHC.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPharmacyLocatorBlayerP2.json" }, tags = { "@pharmacyLocatorRegression","@pharmacylocatorblayer01b" })
public class RunMRATDDAcquisitionPharmacyLocatorBlayerP2{ 
 
}