package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class IllinoisHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		startNew(ILLINOIS_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/soi/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement illinoisfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/soi/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	
	private WebElement illinoisfindaprovidertab;
	
	
	private static String ILLINOIS_HOME_PAGE_URL= MRConstants.ILLINOIS_HOME_PAGE_URL;
	
	public IllinoisHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page illinoishomepageproviderclick() {
	validateNew(illinoisfindaproviderlink);
		
	illinoisfindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public IllinoisFindaProviderPage illinoisprovidertabclick() {
		
		validateNew(illinoisfindaprovidertab);
		
		illinoisfindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase("Retirees and Survivors of an Illinois State-Sponsored Plan – Find a provider")) {
		return new IllinoisFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	}

