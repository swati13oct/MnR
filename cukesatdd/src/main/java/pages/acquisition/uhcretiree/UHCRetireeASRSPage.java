package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author naggarw2
 *
 */

public class UHCRetireeASRSPage extends UhcDriver { 
	
	
	@Override
	public void openAndValidate() {
		
		start(UHCRETIREE_ACQISITION_ASRS_PAGE_URL);

	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/asrs/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement FIND_A_PROVIDER_LINK;
	
	@FindBy(xpath="//*[@id='cq-events-jsp-/content/gr/en/asrs/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement findAPhysician;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/asrs/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	private WebElement providers_link;

	
	
	
	
	private static String UHCRETIREE_ACQISITION_ASRS_PAGE_URL = MRConstants.UHCRETIREE_ASRS_PAGE;
	
	
	public UHCRetireeASRSPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}


	public UHCRetireeASRSProviderPage clickfindAProvider() {
		
		validate(FIND_A_PROVIDER_LINK);
		FIND_A_PROVIDER_LINK.click();
		if (getTitle().equalsIgnoreCase(
				"ASRS and PSPRS Group Retiree – Find a Provider")) {
	return new UHCRetireeASRSProviderPage(driver);
}
		
		
		return null;
		
		
		// TODO Auto-generated method stub
		
	}


	public RallyToolPage clickfindaprovider() {
		
		
			validate(findAPhysician);
			findAPhysician.click();
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


	public UHCRetireeASRSProviderPage clickfindaphysician() {
			
			validate(providers_link);
			providers_link.click();
			if (getTitle().equalsIgnoreCase(
					"ASRS and PSPRS Group Retiree – Find a Provider")) {
		return new UHCRetireeASRSProviderPage(driver);
		
			}
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	
		
	
	
}