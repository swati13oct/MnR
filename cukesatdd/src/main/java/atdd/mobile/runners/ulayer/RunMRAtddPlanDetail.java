/**
 * 
 */
package atdd.mobile.runners.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.plandetail.ulayer" }, 
features = { "feature/mobile/ulayer" }, 
format = {
"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@Ship"})
public class RunMRAtddPlanDetail {

}
