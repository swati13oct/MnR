package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class SdceraHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(SDCERA_HOME_PAGE_URL);
	}
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div/div[3]/div[1]/div[3]/div/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	
	private WebElement sdcerafindaproviderlink;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[5]/div/div")
	
	private WebElement sdcerafindaprovidertab;
	
	
	private static String SDCERA_HOME_PAGE_URL= MRConstants.SDCERA_HOME_PAGE_URL;
	
	public SdceraHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page sdcerahomepageproviderclick() {
	validate(sdcerafindaproviderlink);
		
	sdcerafindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Find Care")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public SdceraFindaProviderPage sdceraprovidertabclick() {
		
		validate(sdcerafindaprovidertab);
		
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

