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
public class TermsnConditionsAARPPage extends GlobalWebElements{
		
	//@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	@FindBy(xpath="(//span[contains(@class,'heading-1')])[3]")
	public WebElement header;
	
	//@FindBy(xpath = "(//section[contains(@class,'meded-article-content')]//p)[1]")
	@FindBy(xpath="(//p//span[contains(@class,'paragraph')])[12]")
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
