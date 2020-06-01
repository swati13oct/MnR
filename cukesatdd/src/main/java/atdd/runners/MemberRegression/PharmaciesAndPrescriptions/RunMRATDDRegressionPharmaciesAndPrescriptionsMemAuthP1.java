package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionPharmaciesAndPrescriptionsMemAuthP1.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPharmaciesAndPrescriptionsMemAuthP1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPharmaciesAndPrescriptionsMemAuthP1.json" }, tags = { "@memAuth_pharmaciesandprescriptions01a" })
public class RunMRATDDRegressionPharmaciesAndPrescriptionsMemAuthP1 {

}
