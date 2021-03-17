package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorVPPLanguageLinksChineseAARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksChineseAARP.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorVPPLanguageLinksChineseAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator" },
plugin = {
		"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDPharmacyLocatorVPPLanguageLinksChineseAARP.json" }, 
		tags = { "@Pharmacy_FromVPP_PharmacyDirectory_Chinese_AARP" })

public class RunMRATDDPharmacyLocatorVPPLanguageLinksChineseAARP{ 
 
}