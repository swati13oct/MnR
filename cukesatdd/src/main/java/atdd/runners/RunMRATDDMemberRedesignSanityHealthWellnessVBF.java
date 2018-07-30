package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDMemberRedesignSanityHealthWellnessVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDMemberRedesignSanityHealthWellnessVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF" }, features = { "src/main/resources/feature/member-redesign-vbf/health-and-wellness" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDMemberRedesignSanityHealthWellnessVBF.json" }, tags = { "@smokeTest_H&W" },monochrome = true)

public class RunMRATDDMemberRedesignSanityHealthWellnessVBF {

}
