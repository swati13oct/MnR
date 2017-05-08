package atdd.mobile.runners.mymedica;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * @author pemmadi
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login.mymedica" }, 
features = { "feature/mobile/mymedica" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@mymedicamobile"})
public class RunMRAtddMedicaLogin {

}
