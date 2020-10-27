package atdd.runners.MemberRegression.HealthRecord.TeamOrStage;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityNoIhr_P4_ship3.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityNoIhr_P4_ship3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthRecord" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityNoIhr_P4_ship3.json" }, tags = { "@no_ihr_p4_ship_sanity","@sanity03" })
public class RunMRATDDSanityNoIhr_P4_ship3 {

}
