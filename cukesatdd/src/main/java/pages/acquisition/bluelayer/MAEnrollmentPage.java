package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import pages.acquisition.bluelayer.ZipcodeLookupHomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;

public class MAEnrollmentPage extends GlobalWebElements {
	
	@Override
	public void openAndValidate() {
		start(MA_ENROLLMENT_PAGE);
		

	}

	
	private static String MA_ENROLLMENT_PAGE = MRConstants.MA_ENROLLMENT_PAGE_URL;
	
	
	@FindBy(xpath="//*[@id='subPageLeft']/div[3]/div[2]/div/div[3]/div[2]/div/div[1]/p[1]/a")
	private WebElement providerlink;

	public MAEnrollmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}




	public Rallytool_Page MAEnrollmentproviderclick() {
		
		validate(providerlink);
		
		providerlink.click();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Find Care")) {
		return new Rallytool_Page(driver);
		}
	
		
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
}