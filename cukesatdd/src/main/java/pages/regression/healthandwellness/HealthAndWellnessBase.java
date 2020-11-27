package pages.regression.healthandwellness;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class HealthAndWellnessBase extends HealthAndWellnessWebElements{

	public HealthAndWellnessBase(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//note: comment out for now, step creating this object may not be landing on the actual page yet
		//validate(rallyHealthAndWellness,120);
	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("slept for '"+sec+"' sec");
	}

	public void hwCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}

	public void goBackToPriorPgViaBack(String origUrlBeforeClick) {
		driver.navigate().back();
		sleepBySec(15);
		CommonUtility.checkPageIsReady(driver);
		String expUrl=origUrlBeforeClick;
		String actUrl=driver.getCurrentUrl();
		if (!actUrl.contains(expUrl)) { //note: give it one more try before giving up
			driver.get(origUrlBeforeClick);
			sleepBySec(5);
			actUrl=driver.getCurrentUrl();
		}
		Assert.assertTrue("PROBLEM - unable to go back to Health and Wellness page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		hwCheckModelPopup(driver);
	}

	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean hwValidate(WebElement element) {
		long timeoutInSec=0;
		return hwValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean hwValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	}

	public String getExpectedDomain() {
		String expectedDomain="https://member.int.uhc.com/";
		if (MRScenario.environment.equalsIgnoreCase("offline")) {
			expectedDomain="https://member.uat.uhc.com/";
		} else if (MRScenario.environment.equalsIgnoreCase("offline")) {
			expectedDomain="https://member.uhc.com/";
		}
		return expectedDomain;
	}
	
	public String getExpectedEnv() {
		String expectedEnv="online-stage";
		if (MRScenario.environment.equalsIgnoreCase("offline")) {
			expectedEnv="offline-prod";
		} else if (MRScenario.environment.equalsIgnoreCase("offline")) {
			expectedEnv="online-prod";
		}
		return expectedEnv;
	}
	

}
