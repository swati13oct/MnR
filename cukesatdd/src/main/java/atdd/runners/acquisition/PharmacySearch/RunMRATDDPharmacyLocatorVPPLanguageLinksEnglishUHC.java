package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorVPPLanguageLinksEnglishUHC
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksEnglishUHC.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorVPPLanguageLinksEnglishUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator" },
plugin = {
		"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksEnglishUHC.json" }, 
		tags = { "@Pharmacy_FromVPP_PharmacyDirectory_English_UHC" })

public class RunMRATDDPharmacyLocatorVPPLanguageLinksEnglishUHC{ 
 
}