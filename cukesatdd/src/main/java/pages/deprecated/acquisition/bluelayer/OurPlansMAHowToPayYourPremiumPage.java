package pages.deprecated.acquisition.bluelayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;
import pages.deprecated.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class OurPlansMAHowToPayYourPremiumPage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		startNew(OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM_URL);
	}
	
	@FindBy(id="PO7link")
	private WebElement ourplansmahowtopayyourpremiumproviderlink;
	
	private static String OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM_URL= MRConstants.OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM_URL;
	
	public OurPlansMAHowToPayYourPremiumPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page ourplansmahowtopayyourpremiumproviderclick() {
		
		{
			validateNew(ourplansmahowtopayyourpremiumproviderlink);
				
			ourplansmahowtopayyourpremiumproviderlink.click();
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				
				if (getTitle().equalsIgnoreCase(
						"Enter Zip")) {
			return new Rallytool_Page(driver);
			}
				// TODO Auto-generated method stub
				return null;
			}
		
	
	

}
}
