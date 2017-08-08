/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

import acceptancetests.atdd.data.PageData;
import atdd.framework.UhcDriver;

/**
 * @author akapoo18
 *
 */
public class ProfilePreferencesPage extends UhcDriver {

	public ProfilePreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public PageData ProfilePreferences;

	public JSONObject ProfilePreferencesJson;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//h2")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div/p[1]//span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[1]//text()")
	private WebElement memberNameText;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[2]//span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[2]//text()")
	private WebElement memberIdtext;

	@FindBy(xpath = "//*[@id='profilePreferencesApp']//div[1]//div//section//div//div[2]//div//div//div//div//div[1]//div//span[1]")
	private WebElement Username;

	@FindBy(xpath = "//*[@id='profilePreferencesApp']//div[1]//div//section//div//div[2]//div//div//div//div//div[1]//div//span[2]")
	private WebElement Usernametext;

	@FindBy(xpath = "//*[@id='profilePreferencesApp']//div[1]//div//section//div//div[2]//div//div//div//div//div[2]//div//div//span[1]")
	private WebElement Password;

	@FindBy(xpath = "//*[@id='profilePreferencesApp']//div[1]//div//section//div//div[2]//div//div//div//div//div[2]//div//div//span[2]")
	private WebElement Passwordtext;

	@FindBy(xpath = "//*[@id='profilePreferencesApp']//div[1]//div//section//div//div[2]//div//div//div//div//div[2]//a")
	private WebElement EditLink;

	@FindBy(xpath = "//*[@id='Artwork']")
	private WebElement EditButton;
	
	@FindBy(xpath = "//*[@id='tab-1']/div[2]/div[1]/div/div[1]/div[1]/div/div/div/div[1]/p")
	private WebElement EmailLabel;

	@FindBy(xpath = "//*[@id='tab-1']/div[2]/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/span[1]")
	private WebElement EmailAddressLabel;
	

	@FindBy(id = "passwordOld")
	private WebElement CurrentPassword;

	@FindBy(id = "passwordNew")
	private WebElement NewPassword;

	@FindBy(id = "passwordNewConfirm")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "//*[@id='updatePassword']/span")
	private WebElement SaveButton;

	@FindBy(xpath = "//*[@id='password-form']/div[4]/div/a")
	private WebElement CancelButton;

	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : ProfilePreferences.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(ProfilePreferences.getExpectedData().get(key));
			/*
			 * if (elements.size() == 1) { validate(elements.get(0)); try {
			 * jsonObject.put(key, elements.get(0).getText());
			 * //System.out.println("Text"+elements.get(0).getText()); } catch
			 * (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } else if (elements.size() > 1) {
			 */
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {

				validate(element);
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put(ProfilePreferences.getExpectedData().get(key).getElementName(),
							element.getText());
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		ProfilePreferencesJson = jsonObject;

		System.out.println("ProfilePreferencesJson----->" + ProfilePreferencesJson);

	}

	public void validatePlanNameMemberidNameAcountProfile() {

		validate(planName);

		System.out.println("Plan name is " + planName.getText());
		validate(memberId);
		validate(memberName);
		// ValidateAccount Profile
		validate(Username);
		System.out.println("Label for Username is  " + Username.getText());
		validate(Usernametext);
		System.out.println("Usernametext is " + Usernametext.getText());
		validate(Password);
		System.out.println("Label for Password is " + Password.getText());
		validate(Passwordtext);
		System.out.println("Passwordtext is " + Passwordtext.getText());

		validate(EditLink);
		System.out.println("Edit link is " + EditLink.isDisplayed());

		validate(EditButton);
		System.out.println("EditButton is " + EditButton.isDisplayed());

	}
	
	public void validateEmail() {
		validateNew(EmailLabel);
		validateNew(EmailAddressLabel);

	}

	public void validateAccountEdit(String password2) {

		EditLink.click();
		CurrentPassword.sendKeys(password2);
		NewPassword.sendKeys(password2 + "1");
		ConfirmPassword.sendKeys(password2 + "1");
		SaveButton.click();

	}

	public void validateAccountEditElements() {
		// TODO Auto-generated method stub

		validateNew(CurrentPassword);
		validateNew(NewPassword);
		validateNew(ConfirmPassword);
		validateNew(SaveButton);
		validateNew(CancelButton);

	}

	public void validateCancelButton() {

		CancelButton.click();
		Assert.isTrue(Password.isDisplayed());

	}


}
