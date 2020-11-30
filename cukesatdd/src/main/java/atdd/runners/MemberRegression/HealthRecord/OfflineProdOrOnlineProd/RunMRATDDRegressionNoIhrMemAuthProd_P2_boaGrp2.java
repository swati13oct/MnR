package atdd.runners.MemberRegression.HealthRecord.OfflineProdOrOnlineProd;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionNoIhrMemAuthProd_P2_boaGrp2.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionNoIhrMemAuthProd_P2_boaGrp2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionNoIhrMemAuthProd_P2_boaGrp2.json" }, tags = { "@prod_no_ihr_p2_boaGrp2" })
public class RunMRATDDRegressionNoIhrMemAuthProd_P2_boaGrp2 {

}
