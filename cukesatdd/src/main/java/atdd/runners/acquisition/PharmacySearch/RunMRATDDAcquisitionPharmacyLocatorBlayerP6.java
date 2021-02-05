package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionPharmacyLocator
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPharmacyLocatorBlayerP6.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPharmacyLocatorBlayerP6")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator/PharmacySearch-Common.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPharmacyLocatorBlayerP6.json" }, tags = { "@PharmacyLocatorCommonUHC04"})//"@pharmacyLocatorRegression","@pharmacylocatorblayer04" })
public class RunMRATDDAcquisitionPharmacyLocatorBlayerP6{ 
 
}