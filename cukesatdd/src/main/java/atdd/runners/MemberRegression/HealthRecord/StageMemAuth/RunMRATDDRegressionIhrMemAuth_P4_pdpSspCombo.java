package atdd.runners.MemberRegression.HealthRecord.StageMemAuth;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionIhrMemAuth_P4_pdpSspCombo.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionIhrMemAuth_P4_pdpSspCombo")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionIhrMemAuth_P4_pdpSspCombo.json" }, tags = { "@memAuth_ihr_p4_pdpSspCombo" })
public class RunMRATDDRegressionIhrMemAuth_P4_pdpSspCombo {

}