package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class ContactUsAARPPage extends GlobalWebElementsMobile{
	 
	@FindBy(xpath = "//*[contains(@class,'meded layout')]")
	public WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'uhc-container')]")
	public WebElement rightRailSection_ProvidersOnly;
	
	@FindBy(id = "collapse2heading_article_mededaccordion0")
	public WebElement ma_AccordialCollapsed;
	
	@FindBy(xpath = "//div[contains(@class,'disclaimer-box')]/p")
	public WebElement disclaimerBox_Para;
	
	
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
