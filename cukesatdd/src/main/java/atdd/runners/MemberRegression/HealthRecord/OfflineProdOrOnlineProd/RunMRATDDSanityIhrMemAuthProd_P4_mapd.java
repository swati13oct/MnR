package atdd.runners.MemberRegression.HealthRecord.OfflineProdOrOnlineProd;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityIhrMemAuthProd_P4_mapd.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityIhrMemAuthProd_P4_mapd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityIhrMemAuthProd_P4_mapd.json" }, tags = { "@prod_ihr_p4_ma_mapd","@sanity" })
public class RunMRATDDSanityIhrMemAuthProd_P4_mapd {

}
