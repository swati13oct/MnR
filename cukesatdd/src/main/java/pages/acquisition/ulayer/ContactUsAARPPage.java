package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class ContactUsAARPPage extends GlobalWebElements{
	 
	@FindBy(xpath = "//*[contains(@class,'heading-1')]")
	public static WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'uhc-container')]")
	public static WebElement rightRailSection_ProvidersOnly;
	
	@FindBy(id = "collapse2heading_article_mededaccordion0")
	public static WebElement ma_AccordialCollapsed;
	
	@FindBy(xpath = "//div[contains(@class,'disclaimer-box')]/p")
	public static WebElement disclaimerBox_Para;
	
	
	public ContactUsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(rightRailSection_ProvidersOnly);
		//validateNew(ma_AccordialCollapsed);
		//validateNew(disclaimerBox_Para);
			
	}

	
	
	

}
