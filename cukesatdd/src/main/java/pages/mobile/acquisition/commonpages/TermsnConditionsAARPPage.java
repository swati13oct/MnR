/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 *
 */
public class TermsnConditionsAARPPage extends GlobalWebElementsMobile{
		
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public WebElement header;
	
	@FindBy(xpath = "(//section[contains(@class,'meded-article-content')]//p)[1]")
	public WebElement pageContent_Para1;
	
	public TermsnConditionsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(pageContent_Para1);
		
	}

	
}
