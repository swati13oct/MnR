package atdd.runners.MemberRegression.HealthRecord;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionHealthRecordMemAuthP5_fedShipCombo_shipFedCombo.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionHealthRecordMemAuthP5_fedShipCombo_shipFedCombo")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionHealthRecordMemAuthP5_fedShipCombo_shipFedCombo.json" }, tags = { "@memAuth_ihr_fedShipCombo_shipFedCombo" })
public class RunMRATDDRegressionHealthRecordMemAuthP5_fedShipCombo_shipFedCombo {

}
