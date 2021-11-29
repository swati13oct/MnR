/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.commonpages.GlobalWebElements;


/**
 * @author saduri
 *
 */
public class AboutUsPageMobile extends GlobalWebElements{
	
	@FindBy(xpath = "//span[contains(@class,'visible-inline-block')][1]")
	public WebElement header;
	
	@FindBy(xpath = "//section[contains(@class,'meded-article-content')]//p[string-length(text()) > '1']")
	public WebElement abountUsBodyParaSection;
	
	@FindBy(css = "#medicareTitle")
	private WebElement aboutUsTitle;
	
	@FindBy(className = "med_cont")
	private WebElement aboutUsTable;
	

	public AboutUsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	



	

	@Override
	public void openAndValidate() {
		
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(abountUsBodyParaSection);
/*		validate(aboutUsTitle);
		validate(aboutUsTable);
		validate(contactUsLink);
		*/
		
	}

}
