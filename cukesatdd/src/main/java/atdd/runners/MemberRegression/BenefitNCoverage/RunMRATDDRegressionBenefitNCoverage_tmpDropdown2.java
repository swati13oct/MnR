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
jsonReport = "target/cucumber-RunMRATDDRegressionBenefitNCoverage_tmpDropdown2.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionBenefitNCoverage_tmpDropdown2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/benefitsandcoverage/PlanBenefitsAndCoverage-UMS.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionBenefitNCoverage_tmpDropdown2.json" }, tags = { "@CMPDPGroupNonLis,@CMFedPDPNonLis,@CMMapdGroupNonLis" })
public class RunMRATDDRegressionBenefitNCoverage_tmpDropdown2 {

}
