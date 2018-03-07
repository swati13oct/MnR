/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

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
public class ReviewApplicationPage extends UhcDriver{
	
	@FindBy(id = "enrollmentNext")
	private WebElement enrollmentNext;

	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
	private WebElement pageHeading;
		
	private PageData reviewApplication;

	public JSONObject reviewApplicationJson;

	public ReviewApplicationPage(WebDriver driver, String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		if(planName.contains("HMO")){
		String fileName = CommonConstants.MA_REVIEW_APPLICATION_PAGE_DATA;
		reviewApplication = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}
		if(planName.contains("PDP")){
			String fileName = CommonConstants.PDP_REVIEW_APPLICATION_PAGE_DATA;
			reviewApplication = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
			}
		
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(enrollmentNext);
		JSONObject jsonObject = new JSONObject();
		for (String key : reviewApplication.getExpectedData().keySet()) {
			WebElement element = findElement(reviewApplication.getExpectedData()
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
		reviewApplicationJson = jsonObject;
		
	}

	public SubmitApplicationPage navigatesToNextStep() {
		enrollmentNext.click();
		if (pageHeading.getText().equalsIgnoreCase(
				"Step 5: Submit Application")) {
			return new SubmitApplicationPage(driver);
		}
		return null;
		
	}
}
