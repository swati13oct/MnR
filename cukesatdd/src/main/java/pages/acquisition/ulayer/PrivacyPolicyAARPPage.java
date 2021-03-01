/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 *
 */
public class PrivacyPolicyAARPPage extends GlobalWebElements{
 
	@FindBy(xpath = "//*[contains(@class,'heading-1')]")
	public static WebElement header;
	
	@FindBy(xpath = "//h2//span[@class='paragraph']")
	public static WebElement pageContent_Para1;
	
	public PrivacyPolicyAARPPage(WebDriver driver) {
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
