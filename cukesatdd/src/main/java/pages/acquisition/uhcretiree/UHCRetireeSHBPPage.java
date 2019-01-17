package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;


/**
 * @author naggarw2
 *
 */

public class UHCRetireeSHBPPage extends UhcDriver { 
	
	
	@Override
	public void openAndValidate() {
		
		start(UHCRETIREE_ACQISITION_SHBP_PAGE_URL);

	}
	
	@FindBy(xpath=".//*[@id='cq-events-jsp-/content/gr/en/shbp/home/jcr:content/parsys/events']/div/div[1]/div[3]/div/div[1]/div[1]/p[3]/a")
	private WebElement findaproviderlink;
	
	@FindBy(xpath=".//*[@id='cq-imagebutton-jsp-/content/gr/en/shbp/header/jcr:content/parsys/textbgimage/parsys/imagebutton_1']")
	private WebElement clickproviderslink;
	
	@FindBy(xpath="//*[@id='main']/div/div[1]/div/div[3]/div[2]/div[8]/div/div/div[1]/a/span")
    private WebElement getstartedbutton;
	
	private static String UHCRETIREE_ACQISITION_SHBP_PAGE_URL = MRConstants.UHCRETIREE_SHBP_PAGE;
	
	
	public UHCRetireeSHBPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}


	public RallyToolPage clickfindaprovider() {
		
		validate (findaproviderlink);
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
		
		validate (clickproviderslink);
		clickproviderslink.click();
		
		if (getTitle().equalsIgnoreCase(
				"Georgia SHBP Retirees – Find a provider")) {
	return new UHCRetireeSHBPProviderPage(driver);
	
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public SalesforceSitePage clickgetstarted() {
		// TODO Auto-generated method stub
		
		validate(getstartedbutton);
		getstartedbutton.click();
		
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PROBLEM_LOADING_PAGE))
		{
			return new SalesforceSitePage(driver);
		}
		
		return null;
	}
	
}