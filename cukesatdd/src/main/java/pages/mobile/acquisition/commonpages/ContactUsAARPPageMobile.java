package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class ContactUsAARPPageMobile extends GlobalWebElements{
	 
	@FindBy(xpath = "//span[contains(text(),'Connect') or contains(text(),'Contact')]")
	public WebElement header;
	
	@FindBy(xpath = "//*[contains(text(),'PROVIDERS ONLY')]")
	public WebElement rightRailSection_ProvidersOnly;
	
	@FindBy(css = "#collapse2heading_article_mededaccordion0")
	public WebElement ma_AccordialCollapsed;
	
	@FindBy(xpath = "//div[contains(@class,'disclaimer-box')]/p")
	public WebElement disclaimerBox_Para;
	
	
	public ContactUsAARPPageMobile(WebDriver driver) {
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
