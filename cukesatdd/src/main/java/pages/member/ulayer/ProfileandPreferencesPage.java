/**
 * 
 */
package pages.member.ulayer;


import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.atdd.data.PageData;
import atdd.framework.UhcDriver;

/**
 * @author akapoo18
 *
 */

public class ProfileandPreferencesPage extends UhcDriver {

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//h2")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='tab-1']//div[1]//div//p[1]//span")
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
	

	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;

	public ProfileandPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		for (String key : ProfileandPreferences.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(ProfileandPreferences.getExpectedData().get(key));
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
					jsonObjectForArray.put(ProfileandPreferences.getExpectedData().get(key).getElementName(),
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

		ProfileandPreferencesPageJson = jsonObject;

		System.out.println("ProfileandPreferencesPageJson----->" + ProfileandPreferencesPageJson);

	}

	public void validatePlanNameMemberidandName() {

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
		System.out.println("EditButton is " + EditButton.isDisplayed() );
	}

	public void validateEmail() {
		validateNew(EmailLabel);
		validateNew(EmailAddressLabel);

	}
}
