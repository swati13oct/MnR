package atdd.runners.Gated;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDMemberRedesignSanityEOBUHCVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDMemberRedesignSanityEOBUHCVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/eob" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDMemberRedesignSanityEOBUHCVBF.json" }, tags = { "@Gating_UHC_EOB" },monochrome = true)

public class RunMRATDDMemberRedesignSanityEOBUHCVBF {

}
