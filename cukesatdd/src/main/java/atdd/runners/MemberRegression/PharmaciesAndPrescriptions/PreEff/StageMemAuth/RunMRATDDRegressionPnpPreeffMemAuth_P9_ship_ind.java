package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.PreEff.StageMemAuth;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionPnpPreeffMemAuth_P9_ship_ind.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPnpPreeffMemAuth_P9_ship_ind")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPnpPreeffMemAuth_P9_ship_ind.json" }, tags = { "@memAuth_pnpPreEff_ship_ind" })
public class RunMRATDDRegressionPnpPreeffMemAuth_P9_ship_ind {

}
