/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class ContactUsUmsPageMobile extends UhcDriver{
	
	@FindBy(xpath = "//div[contains(text(),'Contact Us')]")
	public static WebElement header;
	
	@FindBy(xpath = "//*[contains(text(),'PROVIDERS ONLY')]")
	public static WebElement rightRailSection_ProvidersOnly;
	
	@FindBy(id = "collapse2heading_article_mededaccordion0")
	public static WebElement ma_AccordialCollapsed;
	
	@FindBy(xpath = "//div[contains(@class,'disclaimer-box')]/p")
	public static WebElement disclaimerBox_Para;
	

	public ContactUsUmsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		
	}
	


	@Override
	public void openAndValidate() {
		scrollToView(header);
		//CommonUtility.waitForPageLoadNew(driver, header, 40);
		validateNew(rightRailSection_ProvidersOnly);
		//validateNew(ma_AccordialCollapsed);
		//validateNew(disclaimerBox_Para);
		
		
	}
	
	

}
