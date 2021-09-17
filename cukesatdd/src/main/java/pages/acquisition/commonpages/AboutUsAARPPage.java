/**
 * 
 */
package pages.acquisition.commonpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 *
 */


public class AboutUsAARPPage extends GlobalWebElements{

	//@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	//@FindBy(xpath="//span[contains(text(),'About UnitedHealthcare') and contains(@class,'heading-1')]")
	@FindBy(xpath="//*[@data-heading-component='About us']")
	public WebElement header;
	
	//@FindBy(xpath = "//section[contains(@class,'meded-article-content')]//p[string-length(text()) > '1']")
	//@FindBy(xpath="(//span[contains(@class,'paragraph') and string-length(text()) > '1'])[1]")
	//@FindBy(xpath="(//*[contains(@class,'content-section')]//span[contains(@class,'paragraph') and string-length(text()) > '1'])[1]")
	@FindBy(xpath="(//*[contains(@class,'cmp-text__paragraph')]/p)[3]")
	public WebElement abountUsBodyParaSection;
	
	
	
	public AboutUsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(abountUsBodyParaSection);
	}

	

}
