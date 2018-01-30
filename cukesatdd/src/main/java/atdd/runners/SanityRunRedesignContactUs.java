package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesign.contactus" }, features = { "src/main/resources/feature/memberrdesign/contact-us" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-SanityRunRedesignContactUs.json" }, tags = { "@smokeTest_contactusInd,@smokeTest_contactusGrp" },monochrome = true)

public class SanityRunRedesignContactUs {

}
