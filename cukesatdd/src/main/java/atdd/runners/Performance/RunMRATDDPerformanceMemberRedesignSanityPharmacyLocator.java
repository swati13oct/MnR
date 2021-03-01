package atdd.runners.Performance;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPerformanceMemberRedesignSanityPharmacyLocator.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPerformanceMemberRedesignSanityPharmacyLocator")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/pharmacy-locator" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPerformanceMemberRedesignSanityPharmacyLocator.json" }, tags = { "@pharmacyLocator_Performance" },monochrome = true)

public class RunMRATDDPerformanceMemberRedesignSanityPharmacyLocator {

}
