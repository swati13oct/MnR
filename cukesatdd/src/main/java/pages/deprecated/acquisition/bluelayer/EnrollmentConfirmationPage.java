/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.JsonObject;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class EnrollmentConfirmationPage extends UhcDriver{

	private PageData enrollmentConfirmation;

	public JSONObject enrollmentConfirmationJson;

	public EnrollmentConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ENROLLMENT_CONFIRMATION_PAGE_DATA;
		enrollmentConfirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}

	public boolean validateEnrollmentConfirmationPage(JSONObject actualJson,String planName, String zipCountyInfo  ){
		boolean flag = true;
		try {
			if(!actualJson.get("planName").toString().contains(planName))
				flag = false;
			if(!actualJson.get("zipCountyInfo").toString().contains(zipCountyInfo))
				flag = false;
			if(!actualJson.get("premium").toString().contains("$"))
				flag = false;
			if(!actualJson.get("footer").toString().contains("You have successfully submitted an application to enroll in"))
				flag = false;
			if(!actualJson.get("pageTitle").toString().contains("Enrollment Application Confirmation"))
				flag = false;
			if(!actualJson.get("confirmationNumber").toString().contains("Your confirmation number is"))
				flag = false;
			String confirStringmationNumber = actualJson.get("confirmationNumber").toString().split(" ")[4];
			if(!confirStringmationNumber.matches("\\d+"))
				flag = false;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : enrollmentConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(enrollmentConfirmation.getExpectedData()
					.get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		enrollmentConfirmationJson = jsonObject;
	}

}