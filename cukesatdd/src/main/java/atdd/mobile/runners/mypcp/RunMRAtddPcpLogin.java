package atdd.mobile.runners.mypcp;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pemmadi
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login.mypcp" }, 
features = { "feature/mobile/mypcp" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@mypcpmobile"})
public class RunMRAtddPcpLogin {

}
