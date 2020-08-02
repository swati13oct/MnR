/**
 * 
 */
package pages.acquisition.commonpages;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class EnquiryKitConfirmationPage extends UhcDriver{
	
	private PageData enquiryKitConfirmation;

	public JSONObject enquiryKitConfirmationJson;
	
	@FindBy(xpath = ".//*[@id='medicareTitle']")
	private WebElement medicareTitle;
	
	@FindBy(xpath = "//div[contains(@class,'meded-article-header')]//*[contains(text(),'Order Confirmation')]")
	private WebElement pageHeading;
	
	
	@FindBy(xpath = "//div[contains(@class,'needhelprightrailcontainer')]//div[contains(@class,'module-aside')]//div[contains(@class,'segment-title')]//*[string-length(text())>1]")
	private List<WebElement> rightRailHeading;
	
	@FindBy(xpath = "//div[contains(@class,'needhelprightrailcontainer')]//div[contains(@class,'module-aside')]//div[contains(@class,'content')]//div[contains(@class,'module-aside')]//*[string-length(text())>1]")
	private List<WebElement> rightRailSectionLinks;
	
	public EnquiryKitConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validateNew(pageHeading);
		validateNew(rightRailHeading.get(0));
		validateNew(rightRailHeading.get(1));
		validateNew(rightRailHeading.get(2));
		validateNew(rightRailSectionLinks.get(0));
	}
	
	public boolean validateConfPage(){
		if(validate(medicareTitle))
			return true;
		return false;
	}

}
