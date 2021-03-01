/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author saduri
 *
 */
public class AboutUsPage extends GlobalWebElements{
	
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public static WebElement header;
	
	@FindBy(xpath = "//section[contains(@class,'meded-article-content')]//p[string-length(text()) > '1']")
	public static WebElement abountUsBodyParaSection;
	
	@FindBy(id = "medicareTitle")
	private WebElement aboutUsTitle;
	
	@FindBy(className = "med_cont")
	private WebElement aboutUsTable;
	

	public AboutUsPage(WebDriver driver) {
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
