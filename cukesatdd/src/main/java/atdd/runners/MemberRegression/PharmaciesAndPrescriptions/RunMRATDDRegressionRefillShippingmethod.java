package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionRefillShippingmethod.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionRefillShippingmethod")
@CucumberOptions(
glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/RefillShippingMethod.feature" },
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionRefillShippingmethod.json" },
tags = { "@F481922" }, monochrome =true)
public class RunMRATDDRegressionRefillShippingmethod {

}