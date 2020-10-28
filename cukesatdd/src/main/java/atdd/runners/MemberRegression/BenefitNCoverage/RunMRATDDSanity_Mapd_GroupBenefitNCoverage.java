package atdd.runners.MemberRegression.BenefitNCoverage;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanity_Mapd_GroupBenefitNCoverage.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanity_Mapd_GroupBenefitNCoverage")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/benefitsandcoverage" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanity_Mapd_GroupBenefitNCoverage.json" }, tags = { "@bnc_Stage_Sanity_mapd" })
public class RunMRATDDSanity_Mapd_GroupBenefitNCoverage {

}
