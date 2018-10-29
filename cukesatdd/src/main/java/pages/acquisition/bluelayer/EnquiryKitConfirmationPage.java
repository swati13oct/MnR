package pages.acquisition.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
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

	public EnquiryKitConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
	
	}
	
	public boolean validateConfPage(){
		CommonUtility.waitForPageLoad(driver, medicareTitle, 30);
		if(validate(medicareTitle))
			return true;
		return false;
	}

}

