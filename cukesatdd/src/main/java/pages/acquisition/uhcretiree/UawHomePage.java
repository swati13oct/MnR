package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class UawHomePage extends UhcDriver {
	
	@Override
	public void openAndValidate(){
		start(UAW_HOME_PAGE_URL);
	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/uawtrust/home/jcr:content/parsys/events']/div/div[1]/div[2]/div/div[1]/div[1]/p[3]/a")
	
	public WebElement uawhomepagefindaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/uawtrust/header/jcr:content/parsys/textbgimage/parsys/imagebutton_0']")
	
	public WebElement uawprovidertablink;
	
	
	private static String UAW_HOME_PAGE_URL= MRConstants.UAW_HOME_PAGE_URL;
	
	public UawHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page uawfindaproviderclick()  {
		
		validate(uawhomepagefindaproviderlink);
		
		uawhomepagefindaproviderlink.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
	
		
		if (getTitle().equalsIgnoreCase(
				"Find Care")) {
	return new Rallytool_Page(driver);
	}
		
	
		// TODO Auto-generated method stub
		return null;
	}

	public UawProviderPage uawfindaprovidertabclick() {
		
		validate(uawprovidertablink);
		
		uawprovidertablink.click();
		
		if (getTitle().equalsIgnoreCase(
				"UAW Trust Group Retiree – Find a provider")) {
	return new UawProviderPage(driver);
	}
		
		
		
		
	
		
		
		
		
		
		
	
		// TODO Auto-generated method stub
		return null;
	}
}