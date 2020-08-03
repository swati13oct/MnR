package pages.regression.prepareForNextYear;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

public class AemPage  extends PrepareForNextYearBase {

	private static String aem_username="admin";
	private static String aem_password="admin";

	//--------- AEM -----------------
	@FindBy(xpath="//input[@id='username']")
	protected WebElement aem_usernameField;

	@FindBy(xpath="//input[@id='password']")
	protected WebElement aem_passwordField;

	@FindBy(xpath="//button[@id='submit-button']")
	protected WebElement aem_submtBtn;

	@FindBy(xpath="//iframe[contains(@src,'member.html')]")
	protected WebElement pageIframe;

	@FindBy(xpath="//div[contains(@class,' x-panel cq-editbar cq-element-tabParsys_47header')]//table//td[contains(@class,'x-toolbar-left')]//table//button[text()='Edit']")
	protected WebElement headerMenuTab_editBtn;

	@FindBy(xpath="//a//span[contains(text(),'Prepare For Next Year Configurations')]")
	protected WebElement prepareForNextYearTab;

	@FindBy(xpath="//label[contains(text(),'Feature Toggle')]/..//input[@type='checkbox']")
	protected WebElement featureToggleCheckbox;

	@FindBy(xpath="//label[contains(text(),'Start Date')]/..//td[@class='ux-datetime-date']//input[@type='text']")
	protected WebElement startDateField;

	@FindBy(xpath="//label[contains(text(),'Start Date')]/..//td[@class='ux-datetime-time']//input[@type='text']")
	protected WebElement startTimeField;

	@FindBy(xpath="//label[contains(text(),'End Date')]/..//td[@class='ux-datetime-date']//input[@type='text']")
	protected WebElement endDateField;

	@FindBy(xpath="//label[contains(text(),'End Date')]/..//td[@class='ux-datetime-time']//input[@type='text']")
	protected WebElement endTimeField;

	@FindBy(xpath="//div[@id='cq-sk']//div[contains(@class,'x-window-header')]//div[contains(@class,'toggle')]")
	protected WebElement aemSubMenuWindow_toggle;

	@FindBy(xpath="//div[@id='cq-sk']//li[contains(@class,'x-tab-with-icon')][2]")
	protected WebElement aemSubMenuWindow_pgActions;

	@FindBy(xpath="//button[contains(text(),'Activate Page')]")
	protected WebElement activatePgOption;

	@FindBy(xpath="//table[contains(@class,'cq-btn-ok')]//button")
	protected WebElement saveChagnesOk;

	@FindBy(xpath="//*[contains(text(),'Page successfully activated')]")
	protected WebElement activatedConfirmMsg;

	public AemPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}

	public boolean aemSignin() {
		Assert.assertTrue("PROBLEM - unable to locate username/password/submit button on AEM page", 
				noWaitValidate(aem_usernameField) && noWaitValidate(aem_passwordField) && noWaitValidate(aem_submtBtn));
		sendkeys(aem_usernameField, aem_username);
		sendkeys(aem_passwordField, aem_password);
		aem_submtBtn.click();
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(5);
		if (noWaitValidate(aemSubMenuWindow_toggle))
			return true;
		else
			return false;
	}

	public void aemPgActionWindowmMinimize() {
		try {
			driver.switchTo().defaultContent();
			if (noWaitValidate(aemSubMenuWindow_pgActions)) {
				Assert.assertTrue("PROBLEM - unable to locate the 'AEM' menu option toggle to minimize", noWaitValidate(aemSubMenuWindow_toggle));
				aemSubMenuWindow_toggle.click();
				sleepBySec(1);
			} else {
				System.out.println("AEM action window already minimized, do nothing");
			}
			Assert.assertTrue("PROBLEM - unable to minimize the AEM page action window", !noWaitValidate(aemSubMenuWindow_pgActions));
			sleepBySec(5);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("have trouble minimizing the window, try again...");
			try {
				driver.switchTo().defaultContent();
				if (noWaitValidate(aemSubMenuWindow_pgActions)) {
					Assert.assertTrue("PROBLEM - unable to locate the 'AEM' menu option toggle to minimize", noWaitValidate(aemSubMenuWindow_toggle));
					aemSubMenuWindow_toggle.click();
					sleepBySec(1);
				} else {
					System.out.println("AEM action window already minimized, do nothing");
				}
				Assert.assertTrue("PROBLEM - unable to minimize the AEM page action window", !noWaitValidate(aemSubMenuWindow_pgActions));

			} catch (Exception e2) {
				e2.printStackTrace();
				Assert.assertTrue("PROBLEM 2 - got exception", false);
			}
		}
	}

	public void aemPgActionWindowmMaximize() {
		try {
			driver.switchTo().defaultContent();
			if (!noWaitValidate(aemSubMenuWindow_pgActions)) {
				Assert.assertTrue("PROBLEM - unable to locate the 'AEM' menu option toggle to minimize", noWaitValidate(aemSubMenuWindow_toggle));
				aemSubMenuWindow_toggle.click();
				sleepBySec(1);
			} else {
				System.out.println("AEM action window already maximized, do nothing");
			}
			Assert.assertTrue("PROBLEM - unable to maximize the AEM page action window", noWaitValidate(aemSubMenuWindow_pgActions));
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}

	public void aemPgAction_activatePg() {
		System.out.println("Attempting to activate page now...");
		aemPgActionWindowmMaximize();

		try {
			Assert.assertTrue("PROBLEM - unable to maximize the AEM page action window", noWaitValidate(aemSubMenuWindow_pgActions));
			aemSubMenuWindow_pgActions.click();
			CommonUtility.waitForPageLoad(driver, activatePgOption, 5);
			Assert.assertTrue("PROBLEM - unable to locate the Active Page option on AEM action window", noWaitValidate(activatePgOption));
			activatePgOption.click();
			CommonUtility.checkPageIsReady(driver);
			boolean confirmMsg=false;
			int count=0;
			int maxTry=60;
			while (count<maxTry) {
				count=count+1;
				sleepBySec(1);
				if (noWaitValidate(activatedConfirmMsg)) {
					confirmMsg=true;
					break;
				}
			}
			Assert.assertTrue("PROBLEM - not getting 'Page successfully activated' msg after clicking Activate Page option after waiting '"+maxTry+"' seconds", confirmMsg);
			System.out.println("Got 'Page successfully activated' msg after "+count+" seconds");
			sleepBySec(5);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception when attempting to activate page", false);
		}        

		
		System.out.println("Attempting to clear team-atest cache now...");
		String url="http://dispatcher-publish-team-atest-team-atest.ocp-elr-core-nonprod.optum.com/dispatcher/invalidate.cache";
		HttpURLConnection urlConnection;
		try {
			URL TestURL = new URL(url);
			urlConnection = (HttpURLConnection) TestURL.openConnection();
			urlConnection.setRequestProperty("CQ-Action", "Delete");      
			urlConnection.setRequestProperty("CQ-Handle", "");      
			int responseCode;
			responseCode = urlConnection.getResponseCode();
			System.out.println("TEST - responseCode="+ urlConnection.getResponseCode());
			System.out.println("TEST - responseMessage="+ urlConnection.getResponseMessage());
			Assert.assertTrue("PROBLEM - got non-200 when attempting to clear env cache. | Expected='200', Actual responseCode='"+responseCode+"'", responseCode==200);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception when attempting to clear env cache", false);
		}        
		sleepBySec(5);

	}

	public void navigateToPrepareForNextYearTab() {
		aemPgActionWindowmMinimize();
		if (!noWaitValidate(startDateField) || !noWaitValidate(startTimeField)) {
			sleepBySec(5);
			driver.switchTo().frame(pageIframe);
			sleepBySec(5);
			System.out.println("Proceed to navigate to 'Prepare For Next Year' tab for editing");
			CommonUtility.waitForPageLoad(driver, headerMenuTab_editBtn, 10);
			Assert.assertTrue("PROBLEM - unable to locate the 'Edit' button for top menu section", noWaitValidate(headerMenuTab_editBtn));
			System.out.println("Attempting to click the Edit button for top menu");
			moveMouseToElement(headerMenuTab_editBtn);
			headerMenuTab_editBtn.click();
			System.out.println("Clicked the Edit button for top menu");

			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, prepareForNextYearTab, 10);
			System.out.println("Attempting to click the PrepareForNextYear tab for top menu");
			Assert.assertTrue("PROBLEM - unable to locate the 'Prepare For next Year' tab button from edit menu section", noWaitValidate(prepareForNextYearTab));
			moveMouseToElement(prepareForNextYearTab);
			prepareForNextYearTab.click();
			System.out.println("Clicked the PrepareForNextYear tab for top menu");

			Assert.assertTrue("PROBLEM - unable to locate the 'Feature Toggle' checkbox element", noWaitValidate(featureToggleCheckbox));
			Assert.assertTrue("PROBLEM - unable to locate the 'Start Date' date text box element", noWaitValidate(startDateField));
			Assert.assertTrue("PROBLEM - unable to locate the 'Start Date' time text box element", noWaitValidate(startTimeField));
			Assert.assertTrue("PROBLEM - unable to locate the 'End Date' date text box element", noWaitValidate(endDateField));
			Assert.assertTrue("PROBLEM - unable to locate the 'End Date' date text box element", noWaitValidate(endTimeField));
			Assert.assertTrue("PROBLEM - unable to locate the 'OK' button element", noWaitValidate(saveChagnesOk));
			sleepBySec(1);
		} else {
			System.out.println("No need to navigate to 'Prepare For Next Year' tab for editing");
		}

	}

	public void printMapContent(HashMap<String,String> map) {
		System.out.println(Arrays.asList(map));
	}

	public HashMap<String,String> getCurrentToggleDateTime() {
		try {
			sleepBySec(1);
			aemPgActionWindowmMinimize();
			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			HashMap<String,String> currentAemSetting=new HashMap<String, String>();
			currentAemSetting.put("featureToggle", String.valueOf(featureToggleCheckbox.isSelected()));
			currentAemSetting.put("startDate", startDateField.getAttribute("value"));
			currentAemSetting.put("startTime", startTimeField.getAttribute("value"));
			currentAemSetting.put("endDate", endDateField.getAttribute("value"));
			currentAemSetting.put("endTime", endTimeField.getAttribute("value"));
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(1);
			return currentAemSetting;
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
			return null;
		}
	}

	public void updateAllFields(boolean inputToggleValue, 
			String inputStartDate, String inputStartTime, 
			String inputEndDate, String inputEndTime) {
		try {
			aemPgActionWindowmMinimize();
			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			if (featureToggleCheckbox.isSelected()==inputToggleValue) {
				System.out.println("Feature toggle is already set to '"+inputToggleValue+"', no need to do anything");
			} else {
				moveMouseToElement(featureToggleCheckbox);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", featureToggleCheckbox);
				Assert.assertTrue("PROBLEM - unable to set Feature toggle to expected input value.  Expected to set to='"+inputToggleValue+"' | Current toggle setting='"+featureToggleCheckbox.isSelected()+"'", featureToggleCheckbox.isSelected()==inputToggleValue);
			}
			//note: ----- edit Start Date ------------------------------
			sendkeys(startDateField, Keys.CONTROL + "a");
			sendkeys(startDateField, inputStartDate);
			//note: ----- edit Start Time ------------------------------
			sendkeys(startTimeField, Keys.CONTROL + "a");
			sendkeys(startTimeField, inputStartTime);
			//note: ----- edit End Date ------------------------------
			sendkeys(endDateField, Keys.CONTROL + "a");
			sendkeys(endDateField, inputEndDate);
			//note: ----- edit End Time ------------------------------
			sendkeys(endTimeField, Keys.CONTROL + "a");
			sendkeys(endTimeField, inputEndTime);
			//note: ----- click OK ------------------------------
			saveChagnesOk.click();
			sleepBySec(2);

			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}


	public void updateToggle(boolean inputToggleValue) {
		try {
			aemPgActionWindowmMinimize();
			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			if (featureToggleCheckbox.isSelected()==inputToggleValue) {
				System.out.println("Feature toggle is already set to '"+inputToggleValue+"', no need to do anything");
			} else {
				moveMouseToElement(featureToggleCheckbox);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", featureToggleCheckbox);
				Assert.assertTrue("PROBLEM - unable to set Feature toggle to expected input value.  Expected to set to='"+inputToggleValue+"' | Current toggle setting='"+featureToggleCheckbox.isSelected()+"'", featureToggleCheckbox.isSelected()==inputToggleValue);
				saveChagnesOk.click();
				sleepBySec(2);
			}
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}

	public void updateStartDate(String inputDate) {
		try {
			aemPgActionWindowmMinimize();
			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			sendkeys(startDateField, Keys.CONTROL + "a");
			sendkeys(startDateField, inputDate);
			saveChagnesOk.click();
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}

	public void updateStartTime(String inputTime) {
		try {
			aemPgActionWindowmMinimize();

			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			sendkeys(startTimeField, Keys.CONTROL + "a");
			sendkeys(startTimeField, inputTime);
			saveChagnesOk.click();
			sleepBySec(2);
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}



	public void updateEndDate(String inputDate) {
		try {
			aemPgActionWindowmMinimize();

			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			sendkeys(endDateField, Keys.CONTROL + "a");
			sendkeys(endDateField, inputDate);
			saveChagnesOk.click();
			sleepBySec(2);
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}

	public void updateEndTime(String inputDate) {
		try {
			aemPgActionWindowmMinimize();

			driver.switchTo().frame(pageIframe);
			sleepBySec(1);
			navigateToPrepareForNextYearTab();

			sendkeys(endTimeField, Keys.CONTROL + "a");
			sendkeys(endTimeField, inputDate);
			saveChagnesOk.click();
			sleepBySec(2);
			driver.switchTo().defaultContent(); //note: switch back to default frame to have consistent starting point
			sleepBySec(2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception", false);
		}
	}
	


}