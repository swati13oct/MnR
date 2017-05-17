/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.formsandresources.bluelayer" }, 
		features = { "feature/forms-and-resources/bluelayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@pharmacybenefit,@appoint,@privacypolicy,@noaccordion,@memberrightres,@mapdappealsandgrievances,@ssupappealsandgrievances,@medicaltherapyprog,@seasonflushot,@medicathreapymapd,@prescriptiondrug,@prescriptiondrug,@drugeob,@drugtransition,@disenrollment"})
public class RunMRAtddTestFormsandResources {

}

