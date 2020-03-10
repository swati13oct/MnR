/**
 * 
 */
package pages.acquisition.commonpages;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : enrollmentConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(enrollmentConfirmation.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
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
