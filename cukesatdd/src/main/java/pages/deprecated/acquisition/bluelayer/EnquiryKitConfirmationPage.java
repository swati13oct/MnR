package pages.deprecated.acquisition.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

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
		String fileName = CommonConstants.ENQUIRY_KIT_CONFIRMATION_PAGE_DATA;
		enquiryKitConfirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		JSONObject jsonObject = new JSONObject();
		for (String key : enquiryKitConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(enquiryKitConfirmation.getExpectedData()
					.get(key));
			if (null != element) {
				if(validateNew(element))
				{
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
		enquiryKitConfirmationJson = jsonObject;
		
	}
	
	public boolean validateConfPage(){
		if(validateNew(medicareTitle))
			return true;
		return false;
	}

}

