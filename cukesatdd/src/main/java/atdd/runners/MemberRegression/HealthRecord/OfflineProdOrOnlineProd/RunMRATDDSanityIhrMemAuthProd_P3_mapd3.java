package atdd.runners.MemberRegression.HealthRecord.OfflineProdOrOnlineProd;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityIhrMemAuthProd_P3_mapd3.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityIhrMemAuthProd_P3_mapd3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityIhrMemAuthProd_P3_mapd3.json" }, tags = { "@prod_ihr_p3_mapd_sanity","@prod_sanity03" })
public class RunMRATDDSanityIhrMemAuthProd_P3_mapd3 {

}
