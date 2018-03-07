package pages.deprecated.acquisition.uhcretiree;

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

public class UHCRetireeSHBPPage extends UhcDriver { 
	
	
	@Override
	public void openAndValidate() {
		
		startNew(UHCRETIREE_ACQISITION_SHBP_PAGE_URL);

	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/shbp/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement findaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/shbp/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	private WebElement clickproviderslink;
	
	private static String UHCRETIREE_ACQISITION_SHBP_PAGE_URL = MRConstants.UHCRETIREE_SHBP_PAGE;
	
	
	public UHCRetireeSHBPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}


	public RallyToolPage clickfindaprovider() {
		
		validateNew (findaproviderlink);
		findaproviderlink.click();
		
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


	public UHCRetireeSHBPProviderPage clickfindaphysician() {
		
		validateNew (clickproviderslink);
		clickproviderslink.click();
		
		if (getTitle().equalsIgnoreCase(
				"Georgia SHBP Retirees – Find a provider")) {
	return new UHCRetireeSHBPProviderPage(driver);
	
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}