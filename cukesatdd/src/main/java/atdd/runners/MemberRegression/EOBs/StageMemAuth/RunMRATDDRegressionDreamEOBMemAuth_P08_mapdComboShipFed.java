package atdd.runners.MemberRegression.EOBs.StageMemAuth;

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
jsonReport = "target/cucumber-RunMRATDDRegressionDreamEOBMemAuth_P08_mapdComboShipFed.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionDreamEOBMemAuth_P08_mapdComboShipFed")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/eob" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionDreamEOBMemAuth_P08_mapdComboShipFed.json" }, tags = { "@memAuth_dreamEob01h_mapdComboShipFed" })
public class RunMRATDDRegressionDreamEOBMemAuth_P08_mapdComboShipFed {

}