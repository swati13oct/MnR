package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for entire member redesign Sanity suite
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDMemberSanityHSIDRegistrationVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDMemberSanityHSIDRegistrationVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF.hsidRegistration" }, features = { "src/main/resources/feature/member-redesign-vbf/registration" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDMemberSanityHSIDRegistrationVBF.json" }, tags = { "@smokeTest_HSIDregistration" },monochrome = true)

public class RunMRATDDMemberSanityHSIDRegistrationVBF {

}
