package atdd.runners.Performance;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Benefits and Coverage
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPerformanceMemberRedesignSanityBNC.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPerformanceMemberRedesignSanityBNC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/bnc" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPerformanceMemberRedesignSanityBNC.json" }, tags = { "@benefitsAndCoverage_Performance" },monochrome = true)

public class RunMRATDDPerformanceMemberRedesignSanityBNC {

}
