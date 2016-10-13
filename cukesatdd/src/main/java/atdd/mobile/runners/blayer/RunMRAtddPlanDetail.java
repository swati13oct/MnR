/**
 * 
 */
package atdd.mobile.runners.blayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.plandetail.blayer" }, 
features = { "feature/mobile/ulayer" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@plandetail"})
public class RunMRAtddPlanDetail {

}
