package atdd.runners.Gated;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Benefits and Coverage
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDMemberRedesignSanityBNCVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDMemberRedesignSanityBNCVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, features = { "src/main/resources/feature/memberredesign/benefitsandcoverage" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDMemberRedesignSanityBNCVBF.json" }, tags = { "@vbfGate" },monochrome = true)

public class RunMRATDDMemberRedesignSanityBNCVBF {

}
