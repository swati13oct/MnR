package pages.acquisition.pharmacyLocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

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
}
