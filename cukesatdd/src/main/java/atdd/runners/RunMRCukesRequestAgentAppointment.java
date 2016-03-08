/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.agentappointment" }, 
		features = { "feature/request-agent-appointment" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@agentAppointment"})
public class RunMRCukesRequestAgentAppointment {

}
