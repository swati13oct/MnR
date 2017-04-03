package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/responsive/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@US557073,@US519611,@US540565,@US519614,@medicalbenefits,@OptionalServices,@Prescriptionbenefits"})
public class RunMRATddTestResponsiveVPP {

}
 