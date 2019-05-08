package atdd.runners.Performance;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPerformanceMemberRedesignSanityProfilePreferenceLegacy.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPerformanceMemberRedesignSanityProfilePreferenceLegacy")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/profile-and-preference" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPerformanceMemberRedesignSanityProfilePreferenceLegacy.json" }, tags = { "@smokeTest_ProfileAndPreference, @smokeTest_GoGreen" },monochrome = true)

public class RunMRATDDPerformanceMemberRedesignSanityProfilePreferenceLegacy {

}
