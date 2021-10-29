package pages.acquisition.pharmacyLocator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.support.ui.Select;

public class PharmaacySearchBaseNew extends PharmacySearchWebElementsNew {
	public PharmaacySearchBaseNew(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	protected long defaultPharmacySearchTimeout=2;
	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, pharmacysearchpageheader, 10);
	}
	
	public boolean pharmacyValidate(WebElement element) {
		long timeoutInSec=10;
		return pharmacyValidate(element, timeoutInSec);
	}
	
	public boolean pharmacyValidate(WebElement element, long timeoutInSec) {
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

	public boolean isPlanYear() {
		return pharmacyValidate(yearDropdownLabel);
	}

	public List<String> getListOfAvailablePlanNames() {
		List<String> testNote=new ArrayList<String>();
		Select dropdown = new Select(seletPlandropdown);
		List<WebElement> plans=dropdown.getOptions();
		testNote.add("available plans from plan dropdown on current test env:");
		for(int i=1; i<plans.size(); i++) { //note: first item is 'Select a plan' so skip it
			testNote.add("plan "+i+" is "+plans.get(i).getText());
		}
		return testNote;
	}

	public void selectsPlanName(String planName, String testSiteUrl) {
		scrollToView(seletPlandropdown);
		waitTllOptionsAvailableInDropdown(seletPlandropdown, 45);
//		seletPlandropdown.click();
		jsClickNew(seletPlandropdown);
		sleepBySec(1);
		selectFromDropDownByText(driver, seletPlandropdown, planName);
		sleepBySec(2);
		if (!loadingBlock.isEmpty())
			waitforElementDisapper(loadingSpinner, 90);
		if (!loadingBlock.isEmpty())	//note: if still not done, give it another 30 second
			waitforElementDisapper(loadingSpinner, 90);
		sleepBySec(1); //note: let the page settle down
		jsClickNew(searchbtn);

		// let the plans load, wait for the loading symbol to disappear
		if (!loadingBlock.isEmpty())
			waitforElementDisapper(loadingSpinner, 90);
		if (!loadingBlock.isEmpty()) // note: if still not done, give it another 30 second
			waitforElementDisapper(loadingSpinner, 90);
		sleepBySec(1); // note: let the page settle down
		Assertion.assertTrue("PROBLEM - Pharmacies not displayed", pharmacyValidate(pharmacyCount));
		if (!pharmacyValidate(pharmacyCount)) {
			if ((MRScenario.environmentMedicare.equals("stage"))) {
				//note: check system time and display in assert message if failed to see what is the system time at the time of the test
				String currentSysTime=getAcqTestEnvSysTime(testSiteUrl);
				Assertion.assertTrue("PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. "
								+ "Current system time is '"+currentSysTime+"'",
						pharmacyValidate(pharmacyCount));
			} else {
				Assertion.assertTrue("PROBLEM - Search yield no result, "
								+ "test expects input data to have search result for remaining validation steps, "
								+ "please check user data input or env to see if everything is ok. ",
						pharmacyValidate(pharmacyCount));
			}
		}
		else
			System.out.println("Pharmacy Count: " + pharmacyCount.getText());

		CommonUtility.checkPageIsReady(driver);
	}
}
