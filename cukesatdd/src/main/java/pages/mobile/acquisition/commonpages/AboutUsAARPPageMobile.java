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


public class AboutUsAARPPageMobile extends GlobalWebElements{

	@FindBy(xpath = "//h1[contains(text(),'About us')]")
	public WebElement header;
	
	@FindBy(xpath = "//span[contains(text(),'UnitedHealthcare is dedicated to helping people li')]")
	public WebElement abountUsBodyParaSection;
	
	
	
	public AboutUsAARPPageMobile(WebDriver driver) {
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
