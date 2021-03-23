package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorVPPLanguageLinksChineseUHC
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksChineseUHC.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorVPPLanguageLinksChineseUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator" },
plugin = {
		"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksChineseUHC.json" }, 
		tags = { "@Pharmacy_FromVPP_PharmacyDirectory_Chinese_UHC" })

public class RunMRATDDPharmacyLocatorVPPLanguageLinksChineseUHC{ 
 
}