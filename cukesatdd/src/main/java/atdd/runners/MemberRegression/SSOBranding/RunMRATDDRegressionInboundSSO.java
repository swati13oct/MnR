package atdd.runners.MemberRegression.SSOBranding;

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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionInboundSSO.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionInboundSSO")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 

features = { "src/main/resources/feature/memberredesign/sso/InboundSSO.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionInboundSSO.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionInboundSSO {

}