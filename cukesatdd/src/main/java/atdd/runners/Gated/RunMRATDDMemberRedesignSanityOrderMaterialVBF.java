package atdd.runners.Gated;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDMemberRedesignSanityOrderMaterialVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDMemberRedesignSanityOrderMaterialVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, features = { "src/main/resources/feature/memberredesign/orderplanmaterials" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDMemberRedesignSanityOrderMaterialVBF.json" }, tags = { "@vbfGate" },monochrome = true)

public class RunMRATDDMemberRedesignSanityOrderMaterialVBF {

}