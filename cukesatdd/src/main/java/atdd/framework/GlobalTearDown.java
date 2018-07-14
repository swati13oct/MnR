package atdd.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import cucumber.api.Scenario;
// To be added
import cucumber.api.java.After;

/**
 * This class will take a screen shot of the last screen executed by cucumber
 * and embed it in the report generated. It will take a screen shot for each
 * test in a scenario. Five members in your data, five screen shots.
 * 
 * To take advantage of this functionality, you must use this class as your tear
 * down class. If you don't have your own method marked with the @After
 * annotation, congratulations, this should work. If you do have a class with a
 * method annotated with @After, then that method will override this and you
 * don't get screen shots unless you add that functionality to your method.
 * 
 * To take advantage of this class, you must not destroy the active WebDriver.
 * WebDriver is the object that keeps track of where your web browser is and it
 * also is responsible for taking screen shots. When it comes time to kill the
 * WebDriver, this class will call the method, nullifyWebDriver on MRScenario
 * which destroys WebDrivier for you.
 * 
 * So two things: 1) Don't kill WebDriver; 2) Don't have a method annotated
 * with @After. That's it. You shouldn't have to do anything more.
 * 
 * Oh yeah, did I mention that I'm assuming that loginScenario is basically the
 * only instance of MRScenario.
 * 
 * @author jantolak
 *
 */
public class GlobalTearDown {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {

		return loginScenario;
	}
	/**
	 * 
	 * @param scenario
	 */
	@After
	public void tearDown(Scenario scenario) {

		if(null !=getLoginScenario()  && null!=getLoginScenario().getBean(CommonConstants.WEBDRIVER))
		{
		    WebDriver wd  =(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			final byte[] screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
			
			// To get the report embedded in the report
			scenario.embed(screenshot, "image/png");
			if (MRScenario.isSauceLabSelected) {
				String html = "<strong>SauceLabs video link</strong><br />";
				html = html.concat("<a href=" + MRScenario.returnJobURL() + ">Go to video</a>");
				scenario.embed(html.getBytes(), "text/html");
			}
			MRScenario mrScen = new MRScenario();
			// Clean up the existing webdriver.
			try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 //mrScen.DriverQuit();
		}

	}
	// to be added
	/**
	 * 
	 * @param scenario
	 */
	/*@After
	public void tearDown(Scenario scenario) 
	//{

		if (null != getLoginScenario() && null != getLoginScenario().getBean(CommonConstants.WEBDRIVER)) {
			//To get the report embedded in the report
			getLoginScenario().CaptureScreenshot(scenario);

			// Clean up the existing webdriver.
			getLoginScenario().nullifyWebDriverNew();
		} else {
			Assert.fail("Screenshot not captured and webdriver not quitted...");
    }

	}*/

}
