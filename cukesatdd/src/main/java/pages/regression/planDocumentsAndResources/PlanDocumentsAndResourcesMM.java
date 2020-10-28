package pages.regression.planDocumentsAndResources;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;

import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesMM extends PlanDocumentsAndResourcesBase  {

	public PlanDocumentsAndResourcesMM(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/** 
	 * Validate header section of Membership Materials
	 * @param sectionDisplay
	 */
	public void validateSectionHeader_MM(boolean sectionDisplay) {
		String section="Membership Materials";
		WebElement headerElement=sectionHeader_MM;

		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate page section header text element", planDocValidate(headerElement));
			String actualHeaderText=headerElement.getText();
			String expectedHeaderText=section;
			Assert.assertTrue("PROBLEM - not getting expected section header text for section '"+section+"'.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));
		} else {
			Assert.assertTrue("PROBLEM - should not locate page section header text element", !planDocValidate(headerElement));
		}
	}

	/**
	 * Validate jumplink for Membership Materials
	 * @param sectionDisplay
	 */
	public void validateJumplink_MM(boolean sectionDisplay) {
		String item="Membership Materials";
		WebElement sectionElement=sectionHeader_MM;
		WebElement jumpLinkElement=jumpLink_MM;
		
		if (sectionDisplay) {
			Assert.assertTrue("PROBLEM - unable to locate jumplink for '"+item+"'", planDocValidate(jumpLinkElement));
			jumpLinkElement.click();
			CommonUtility.waitForPageLoad(driver, sectionElement, 5);
			Assert.assertTrue("PROBLEM - unable to locate section for '"+item+"' after clicking jumplink", planDocValidate(sectionElement));
		} else {
			Assert.assertTrue("PROBLEM - should not locate jumplink for '"+item+"'", !planDocValidate(jumpLinkElement));
		}
	}
	
	/**
	 * Validate default language selection for Membership Materials section
	 */
	public void validateDefaultLangSelect_MM(boolean sectionDisplay) {
		String section="Membership Materials";
		String expectedDefaultText="ENGLISH";
		WebElement dropdownElement=langDropDown_MM;
		
		if (!sectionDisplay) {
			Assert.assertTrue("PROBLEM - input expected not to see section, should not be able to locate language dropdown for section '"+section+"'", !planDocValidate(dropdownElement));
			return;
		}
		Assert.assertTrue("PROBLEM - unable to locate language dropdown for section '"+section+"'", planDocValidate(dropdownElement));
		Select select = new Select(dropdownElement);
		WebElement option = select.getFirstSelectedOption();
		String actualDefaultOptionText = option.getText();
		Assert.assertTrue("PROBLEM - not getting expected default option for language dropdown for '"+section+"'. "
				+ "Expected='"+expectedDefaultText+"' | Actual='"+actualDefaultOptionText+"'", 
				expectedDefaultText.equals(actualDefaultOptionText));
	}
	
	public void reloadPgWorkaround_MM() {
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		try {
			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");

			driver.navigate().refresh();
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - page still laoding after "+forceTimeoutInMin+" min, probably stuck, kill test now. Exception: "+e.getMessage(),false);
		} catch (WebDriverException we) {
			System.out.println("Got driver exception while waiting for page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - Got driver exception while waiting for page to finish loading. Exception: "+we.getMessage(),false);
		}

		System.out.println("page load should stopped loading now, give it 2 more sec to settle down");
		sleepBySec(3);// note: give it a bit more time to settle down
		pageLoad.stop();
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
		System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
		System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
		checkModelPopup(driver, 2);
	}
}