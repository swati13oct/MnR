package pages.deprecated.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class SdceraHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		startNew(SDCERA_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/sdcera/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement sdcerafindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/sdcera/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	
	private WebElement sdcerafindaprovidertab;
	
	
	private static String SDCERA_HOME_PAGE_URL= MRConstants.SDCERA_HOME_PAGE_URL;
	
	public SdceraHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page sdcerahomepageproviderclick() {
	validateNew(sdcerafindaproviderlink);
		
	sdcerafindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public SdceraFindaProviderPage sdceraprovidertabclick() {
		
		validateNew(sdcerafindaprovidertab);
		
		sdcerafindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase(
					"SDCERA Group Retiree – Find a provider")) {
		return new SdceraFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	}

