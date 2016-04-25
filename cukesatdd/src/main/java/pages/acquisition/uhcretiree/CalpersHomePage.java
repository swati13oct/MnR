package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class CalpersHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(CALPERS_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/calpers/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement calpersfindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/calpers/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	
	private WebElement calpersfindaprovidertab;
	
	
	private static String CALPERS_HOME_PAGE_URL= MRConstants.CALPERS_HOME_PAGE_URL;
	
	public CalpersHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page calpershomepageproviderclick() {
	validate(calpersfindaproviderlink);
		
	calpersfindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Find Care")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public CalperFindaProviderPage calperprovidertabclick() {
		
		validate(calpersfindaprovidertab);
		
		calpersfindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase(
					"CalPERS Group Retiree – Find a provider")) {
		return new CalperFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	}

