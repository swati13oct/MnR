/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

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

	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h3")
	private WebElement pageHeading;

	private PageData reviewApplication;

	public JSONObject reviewApplicationJson;

	public ReviewApplicationPage(WebDriver driver, String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		if(planName.contains("HMO")){
			String fileName = CommonConstants.MA_REVIEW_APPLICATION_PAGE_DATA;
			reviewApplication = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		}
		if(planName.contains("PDP")){
			String fileName = CommonConstants.PDP_REVIEW_APPLICATION_PAGE_DATA;
			reviewApplication = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		}

		openAndValidate();
	}

	public boolean validateReviewApplicationPage(JSONObject reviewapplicationObject, String planName,
			String zipCountyInfo, String name, String dob, String gender, String city, String address,
			String apartment, String addressPreference, String emailAddress, String phNumber,
			String otherPhNumber, String mcareNumber,String languagePreference){
		boolean flag = true;
		try {

			System.out.println(reviewapplicationObject.get("planName"));
			System.out.println(planName);
			if(!reviewapplicationObject.get("planName").toString().contains(planName))
				flag = false;
			if(!reviewapplicationObject.get("zipCountyInfo").toString().equals(zipCountyInfo))
				flag = false;
			if(!reviewapplicationObject.get("premium").toString().contains("$"))
				flag = false;
			System.out.println(reviewapplicationObject.get("streetAddress"));
			System.out.println(address);
			if(!reviewapplicationObject.get("streetAddress").toString().contains(address))
				flag = false;
			System.out.println(reviewapplicationObject.get("medicareClaimNumber").toString().replace("-", ""));
			System.out.println(mcareNumber);
			if(!reviewapplicationObject.get("medicareClaimNumber").toString().replace("-", "").contains(mcareNumber))
				flag = false;
			System.out.println(reviewapplicationObject.get("sex"));
			System.out.println(gender);
			if(!reviewapplicationObject.get("sex").toString().contains(gender))
				flag = false;
			System.out.println(reviewapplicationObject.get("mainPhoneNumber").toString().replace("(", "")
					.replace(")", "").replace(" ", "").replace("-", ""));
			System.out.println(phNumber);
			if(!reviewapplicationObject.get("mainPhoneNumber").toString().replace("(", "")
					.replace(")", "").replace(" ", "").replace("-", "").contains(phNumber))
				flag = false;
			System.out.println(reviewapplicationObject.get("languagePreference"));
			System.out.println(languagePreference);
			if(!reviewapplicationObject.get("languagePreference").toString().contains(languagePreference))
				flag = false;
			System.out.println(reviewapplicationObject.get("emailAddress"));
			System.out.println(emailAddress);
			if(!reviewapplicationObject.get("emailAddress").toString().contains(emailAddress))
				flag = false;
			System.out.println(reviewapplicationObject.get("apartment"));
			System.out.println(apartment);
			if(!reviewapplicationObject.get("apartment").toString().contains(apartment))
				flag = false;
			/*System.out.println(reviewapplicationObject.get("otherPhoneNumber").toString().replace("(", "")
					.replace(")", "").replace(" ", "").replace("-", ""));
			System.out.println(otherPhNumber);
			if(!reviewapplicationObject.get("otherPhoneNumber").toString().replace("(", "")
					.replace(")", "").replace(" ", "").replace("-", "").contains(otherPhNumber))
				flag = false;*/
			System.out.println(reviewapplicationObject.get("city"));
			System.out.println(city);
			if(!reviewapplicationObject.get("city").toString().contains(city))
				flag = false;
			System.out.println(reviewapplicationObject.get("name"));
			System.out.println(name);
			if(!reviewapplicationObject.get("name").toString().contains(name))
				flag = false;
			System.out.println(reviewapplicationObject.get("birthDate"));
			System.out.println(dob);
			if(!reviewapplicationObject.get("birthDate").toString().contains(dob))
				flag = false;
			System.out.println(reviewapplicationObject.get("mailingAddress"));
			System.out.println(addressPreference);
			if(!reviewapplicationObject.get("mailingAddress").toString().contains(addressPreference))
				flag = false;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
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