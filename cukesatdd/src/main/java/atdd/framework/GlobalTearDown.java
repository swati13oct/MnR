package atdd.framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.appium.java_client.AppiumDriver;

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
	
	private String SaucelabsVideoUrl = "<strong>SauceLabs video link</strong><br /><a href=%s >Go to video</a>";

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * 
	 * @param scenario
	 */
	@After
	public void tearDown(Scenario scenario) {
		try {
			 if(null !=getLoginScenario() && null!=getLoginScenario().getBean(CommonConstants.WEBDRIVER)) {
				 WebDriver driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
				// AppiumDriver wd1 =(AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);		
				 scenario.attach(takeScreenshot(driver), "image/png", "Screenshot");
				if (MRScenario.isSauceLabSelected) {
					scenario.attach(embedSaucelabsVideoUrl(loginScenario.returnJobURL()), "text/html", "Job URL");
				}

				if (null != getLoginScenario().getBean(LoginCommonConstants.USERNAME)) {
					scenario.log("USER NAME USED : " + getLoginScenario().getBean(LoginCommonConstants.USERNAME));
				}
				// Clean up the existing webdriver.
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.quit();
				System.out.println("---- Script Execution Completed ----");
			} else {
				scenario.log("Teardown received a null object !");
			}
		} catch (WebDriverException e) {
			if (null != getLoginScenario().getBean(LoginCommonConstants.USERNAME)) {
				scenario.log("USER NAME USED : " + getLoginScenario().getBean(LoginCommonConstants.USERNAME));
				Assert.assertTrue(false, "Got WebDriverException. USER NAME USED : "
						+ getLoginScenario().getBean(LoginCommonConstants.USERNAME) + " | "
						+ "SauceLab video link for the job='" + loginScenario.returnJobURL() + "' | exception: " + e);
			} else {
				Assert.assertTrue(false, "Got WebDriverException. SauceLab video link for the job='"
						+ loginScenario.returnJobURL() + "' | exception: " + e);
			}
		} finally {
			//Cleaning up ThreadLocal variables
			getLoginScenario().flushBeans();
			getLoginScenario().flushThreadLocals();
		}
	}
	
	public final byte[] takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public byte[] embedSaucelabsVideoUrl(String jobUrl) {
		return String.format(SaucelabsVideoUrl, jobUrl).getBytes();
	}

}
