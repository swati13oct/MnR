package pages.mobile.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class RegistrationAARPErrorPage extends UhcDriver {
	
	private PageData regErrorPage;
	public JSONObject regErrorPageJson;

	public RegistrationAARPErrorPage(WebDriver driver) {
		   super(driver);
	       PageFactory.initElements(driver, this);
	       String fileName = CommonConstants.REGISTRATION_ERROR_PAGE_DATA;
	       regErrorPage = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
	       openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : regErrorPage.getExpectedData().keySet()) {
			WebElement element = findElement(regErrorPage.getExpectedData().get(key));
			if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		regErrorPageJson = jsonObject;
		System.out.println("regErrorPageJson----->"+regErrorPageJson);
		
	}	

}
