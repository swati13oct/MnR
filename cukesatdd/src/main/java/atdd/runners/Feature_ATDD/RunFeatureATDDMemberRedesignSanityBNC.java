package atdd.runners.Feature_ATDD;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Benefits and Coverage
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunFeatureATDDMemberRedesignSanityBNC.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunFeatureATDDMemberRedesignSanityBNC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/bnc" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunFeatureATDDMemberRedesignSanityBNC.json" }, tags = { "@smokeTest_BenefitsAndCoverageInd, @smokeTest_BenefitsAndCoverageGrp" },monochrome = true)

public class RunFeatureATDDMemberRedesignSanityBNC {

}
