package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class SanFranciscoHomePage extends UhcDriver{

	@Override
	public void openAndValidate(){
		start(San_Francisco_HOME_PAGE_URL);
	}
	
	@FindBy(xpath="//div[@id='cq-events-jsp-/content/gr/en/sfhss/home/jcr:content/parsys/events']/div/div/div[3]/div/div/div/p[3]/a")
	
	private WebElement sanfranciscofindaproviderlink;
	
	@FindBy(xpath="//div[@id='cq-imagebutton-jsp-/content/gr/en/sfhss/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	
	private WebElement sanfranciscofindaprovidertab;
	
	
	private static String San_Francisco_HOME_PAGE_URL= MRConstants.San_Francisco_HOME_PAGE_URL;
	
	public SanFranciscoHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public Rallytool_Page sanfranciscohomepageproviderclick() {
	validate(sanfranciscofindaproviderlink);
		
	sanfranciscofindaproviderlink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}

	public SanfranciscoFindaProviderPage sanfranciscoprovidertabclick() {
		
		validate(sanfranciscofindaprovidertab);
		
		sanfranciscofindaprovidertab.click();
			/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			if (getTitle().equalsIgnoreCase("City and County of San Francisco Group Retiree – Find a Provider")) {
		return new SanfranciscoFindaProviderPage(driver);
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
