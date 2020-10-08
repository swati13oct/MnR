package atdd.runners.MemberRegression.Claims;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityClaimsRallyMemAuthProd_MAPD_Individual.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityClaimsRallyMemAuthProd_MAPD_Individual")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/claims" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityClaimsRallyMemAuthProd_MAPD_Individual.json" }, tags = {"@claims_prodsanityMapd_Individual" })
public class RunMRATDDSanityClaimsRallyMemAuthProd_MAPD_Individual {
}
