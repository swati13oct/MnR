package atdd.runners.MemberRegression.Claims.deprecated;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionClaimsMicroAppDevDrugP2.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionClaimsMicroAppDevDrugP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/claims" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionClaimsMicroAppDevDrugP2.json" }, tags = { "@devRegression","@claimsMicroApp","@pdp_drug" })
public class RunMRATDDRegressionClaimsMicroAppDevDrugP2 {
//note: use this runner for drug claims
}
