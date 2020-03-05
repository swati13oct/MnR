package pages.acquisition.commonpages;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member_deprecated.ulayer.AccountHomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class RegistrationSuccessPage extends UhcDriver {

	@FindBy(linkText = "go to My Account home")
	private WebElement homePageLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(id = "contentRow")
	private WebElement registrationSuccessContent;

	private PageData registrationSuccess;

	public JSONObject registrationSuccessJson;

	public RegistrationSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.REGISTRATION_SUCCESS_PAGE_DATA;
		registrationSuccess = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public String getContent() {
		return registrationSuccessContent.getText(); // get page id
	}

	public AccountHomePage navigateToHomePage() {
		homePageLink.click();
		if (getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | My Account Home"))
			return new AccountHomePage(driver);
		else
			return null;

	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {
		validate(homePageLink);
		validate(registrationSuccessContent);
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : registrationSuccess.getExpectedData().keySet()) {
			WebElement element = findElement(registrationSuccess
					.getExpectedData().get(key));
			if(element != null)
			{
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		}
		registrationSuccessJson = jsonObject;
		
		System.out.println("registrationSuccessJson---->"+registrationSuccessJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap, JSONObject registrationCommonExpected) {
		
		JSONObject registrationSuccessExpectedJson = expectedDataMap
				.get(CommonConstants.REGISTRATION_SUCCESS);
		String dateOfBirth = null;
		String name = null;
		
		try {
			JSONObject jsonObject = registrationCommonExpected.getJSONArray("dateOfBirth").getJSONObject(0);
			dateOfBirth = jsonObject.getString("dob");
			
			JSONObject jsonObject2 = registrationCommonExpected.getJSONArray("memberName").getJSONObject(0);
			name = jsonObject2.getString("name");
			
			if(null!=dateOfBirth)
			{
				registrationSuccessExpectedJson.put("dateOfBirth", dateOfBirth);
			}
			
			if(null!=name)
			{
				String[] fullName = name.split(" ");
				String firstName = fullName[0];
				String lastName = fullName[1];
				registrationSuccessExpectedJson.put("firstName", firstName);
				registrationSuccessExpectedJson.put("lastName", lastName);
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("registrationSuccessExpectedJson---->"+registrationSuccessExpectedJson);
		
		return registrationSuccessExpectedJson;
	}

	public boolean validateRegistrationSuccessPage() {
		
		boolean flag = false;
		for (String key : registrationSuccess.getExpectedData().keySet()) {
			System.err.println("key::"+key);
			WebElement element = findElement(registrationSuccess.getExpectedData()
					.get(key));

			if (validate(element) && null != element.getText()
					&& element.getText() != "") {
				flag = true;
			} else {
				return false;
			}
		}

		return flag;
	}
}
