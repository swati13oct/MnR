package pages.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.ulayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
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
		CommonUtility.checkPageIsReady(driver);
		return registrationSuccessContent.getText(); // get page id
	}

	public AccountHomePage navigateToHomePage() {
		homePageLink.click();
		if (driver.getTitle().equalsIgnoreCase(
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
	}
}
