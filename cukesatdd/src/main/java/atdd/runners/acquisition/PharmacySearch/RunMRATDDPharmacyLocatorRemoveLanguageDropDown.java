package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorRemoveLanguageDropDown
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorRemoveLanguageDropDown.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorRemoveLanguageDropDown")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {"src/main/resources/feature/acquisition/pharmacylocator"},
plugin = {
		"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDPharmacyLocatorRemoveLanguageDropDown.json" }, 
		tags = { "@Pharmacy_Locator_HomePage_RemoveLanguageDropDown_AARP"})

public class RunMRATDDPharmacyLocatorRemoveLanguageDropDown{ 
 
}