package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/responsive/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@US557073"})
				 //,@US544368,@US557073,@US519611,@US540565,@US519614,@US519618,@medicalbenefits,@PlanCosts,@OptionalServices,@Prescriptionbenefits"})
public class RunMRATddTestResponsiveVPP {

}
 