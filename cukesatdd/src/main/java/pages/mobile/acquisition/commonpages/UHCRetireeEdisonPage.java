package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author naggarw2
 *
 */

public class UHCRetireeEdisonPage extends UhcDriver { 

	
	
	@Override
	public void openAndValidate() {
		
		start(UHCRETIREE_ACQISITION_EDISON_PAGE_URL);
			
	}
	
	@FindBy(xpath =".//*[@id='cq-events-jsp-/content/gr/en/edison/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement findprovideredison;	
	
	@FindBy(xpath =".//*[@id='cq-imagebutton-jsp-/content/gr/en/edison/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	private WebElement findprovideredisonlink;
	
	private static String UHCRETIREE_ACQISITION_EDISON_PAGE_URL = MRConstants.UHCRETIREE_EDISON_URL;
	
	public UHCRetireeEdisonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	public RallyToolPage clickfindprovider() {
		
		validate (findprovideredison);
		findprovideredison.click();
		
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new RallyToolPage(driver);
	
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	public UHCRetireeEdisionProviderPage clickfindaprovider() {
		
		validate (findprovideredisonlink);
		findprovideredisonlink.click();
		
		if (getTitle().equalsIgnoreCase(
				"Edison Retirees � Find a Provider")) {
	return new UHCRetireeEdisionProviderPage(driver);
}
		// TODO Auto-generated method stub
		return null;
	}

	
}