package atdd.runners.MemberRegression.HealthAndWellness;


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
jsonReport = "target/cucumber-RunMRATDDSanityHealthAndWellnessMemAuthProd_ship.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityHealthAndWellnessMemAuthProd_ship")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthandwellness" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityHealthAndWellnessMemAuthProd_ship.json" }, tags = { "@prod_sanity","@prod_healthAndWellness01_pdp_ship" })
public class RunMRATDDSanityHealthAndWellnessMemAuthProd_ship {

}