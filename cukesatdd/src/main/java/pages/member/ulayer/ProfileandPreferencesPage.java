/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
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

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]/p/b")
	private WebElement Passwordtext;

	@FindBy(xpath = ".//*[@id='password']/a")
	private WebElement EditLink;

	@FindBy(xpath=".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[1]/p")
	private WebElement EmailLabel;

	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/span[1]/p")
	private WebElement EmailAddressLabel;

	@FindBy(id = "passwordOld")
	private WebElement CurrentPassword;

	@FindBy(id = "passwordNew")
	private WebElement NewPassword;

	@FindBy(id = "passwordNewConfirm")
	private WebElement ConfirmPassword;

	@FindBy(id="updatePassword")
	private WebElement SaveButton;

	@FindBy(xpath = ".//*[@id='passwordForm']/div[4]/div/a")
	private WebElement CancelButton;
	
	@FindBy(className = "margin-none")
    private WebElement Seemorewaystext;
	
	@FindBy(className="lowercase")
	private WebElement contactUs;
	
	@FindBy(xpath = "html/body/div[4]/div/div[2]/section/div/div[1]/div/h2")
	private WebElement NeedHelpHeader;
	
	@FindBy(xpath ="html/body/div[4]/div/div[2]/section/div/div[2]/div/div/div[1]/div/div")
	private WebElement Technicalsupportsection;
	
	@FindBy(xpath ="html/body/div[4]/div/div[2]/section/div/div[2]/div/div/div[2]/div/div")
	private WebElement PlanSupportsection;
	
	@FindBy(xpath ="html/body/div[5]/div/div/div/div/a")
	private WebElement Disclaimerlink;
	
	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[1]")
	private WebElement EmailEditbutton;
	
	@FindBy(xpath=".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div")
	private WebElement Emailform;
	
	@FindBy(id = "profileemailaddress")
	private WebElement email;
	
	@FindBy(id = "emailNew")
	private WebElement NewEmail;

	@FindBy(id = "emailNewConfirm")
	private WebElement emailConfirm;
	
	@FindBy(id="emailNew-error")
	private WebElement mandatorymessage;
	
	@FindBy(id="emailNewConfirm-error")
	private WebElement emailerrormessage;
	
	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[2]")
	private WebElement CanceEmaillButton;
	
	@FindBy(id="updateEmail")
	private WebElement SaveEmailButton;
	
	@FindBy(xpath = ".//*[@id='tab-1']/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div")
	private WebElement permanentaddress;
	
	@FindBy(className = "text-link")
	private WebElement contactuslink;
	
	@FindBy(id="passwordOld-error")
	private WebElement passworderrormessage;
	
	
	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/p")
	private WebElement PhoneHeader;
	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[1]")
	private WebElement PhoneEditButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[1]/svg")
	private WebElement PhoneEditLink;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[1]")
	private WebElement Daytimephone;
	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/span[1]")
	private WebElement EveningPhone;

	@FindBy(xpath = "//*[@id='phone-form']/div[3]/div/button/span")
	private WebElement PhoneSaveButton;

	@FindBy(xpath = "//*[@id='phone-form']/div[3]/div/a")
	private WebElement PhoneCancelButton;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div/div/div/div/a[2]")
	private WebElement PhoneTopCancelButton;

	@FindBy(id = "daytimePhone")
	private WebElement DaytimePhoneTextField;

	@FindBy(id = "eveningPhone")
	private WebElement EveningTimePhoneTextField;

	@FindBy(id = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/span[2]")
	private WebElement eveningPhoneValue;

	@FindBy(xpath = "//*[@id='tab-1']/div[3]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/span[2]")
	private WebElement DaytimePhoneValue;
	
	
	public static final String Disclaimerlinkcontent_xpath = ".//*[@id='collapseDisclaimer']";
	
	public PageData ProfileandPreferences;

	public JSONObject ProfileandPreferencesPageJson;
	
	
   public ProfileandPreferencesPage(WebDriver driver) 
   {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA;
		//ProfileandPreferences = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() 
	{
		/*// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		for (String key : ProfileandPreferences.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(ProfileandPreferences.getExpectedData().get(key));
			
			
			 * if (elements.size() == 1) { validate(elements.get(0)); try {
			 * jsonObject.put(key, elements.get(0).getText());
			 * //System.out.println("Text"+elements.get(0).getText()); } catch
			 * (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } else if (elements.size() > 1) {
			 
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

		System.out.println("ProfilePreferencesJson----->" + ProfileandPreferencesPageJson);
*/
	}

	
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*get PHR expected data*/
		JSONObject profilenpreferencesExpectedJson = expectedDataMap.get(CommonConstants.PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, globalExpectedJson);
		profilenpreferencesExpectedJson = CommonUtility.mergeJson(profilenpreferencesExpectedJson, commonExpectedJson);

		return profilenpreferencesExpectedJson;

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

		
	}

	public void validateEmail() 
	{
		validateNew(EmailLabel);
		validateNew(EmailAddressLabel);
		validateNew(EmailEditbutton);
		EmailEditbutton.click();
	    
	}
	
	public boolean validateemailsavefunctionality()  {
		EmailEditbutton.click();
		NewEmail.sendKeys("nikitajain3@gmail.com");
		emailConfirm.sendKeys("nikitajain3@gmail.com");
		SaveEmailButton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(email.getText().equals("nikitajain3@gmail.com"))
		{
			System.out.println("The element" + email.getText() + "is found");
            return true;
			}
			else
			{
            Assert.fail("The element " + email.getText() + "is not found");
            }
			return false;
			}
	
	public boolean emailblankfieldsvalidation()
	{
		
		SaveEmailButton.click();
	    if(mandatorymessage.getText().contentEquals("This field is required."))
	    {
	    	System.out.println("The element" + mandatorymessage.getText() + "is found");
            return true;
			}
			else
			{
            Assert.fail("The element " + mandatorymessage.getText() + "is not found");
            }
			return false;
		}
			
	public void validateinvalidemailerrormessage()  {
	EmailEditbutton.click();	
	NewEmail.sendKeys("nikitajain");	
	SaveEmailButton.click();
	if(mandatorymessage.getText().contentEquals("Please enter a valid email Address."))
    {
    	System.out.println("The element" + mandatorymessage.getText() + "is found");
        }
		else
		{
        Assert.fail("The element " + mandatorymessage.getText() + "is not found");
        }
	   
	   CanceEmaillButton.click();
    }
	
	public boolean validateduplicateerrormessage()  
	{
	EmailEditbutton.click();
	emailConfirm.sendKeys("nikit");		
	SaveEmailButton.click();
	if(emailerrormessage.getText().contentEquals("Please enter the same value again."))
    {
    	System.out.println("The element" + emailerrormessage.getText() + "is found");
        return true;
		}
		else
		{
        Assert.fail("The element " + emailerrormessage.getText() + "is not found");
        }
	   return false;
    }
		
	
	
	public void validateeditform()
	{
		EmailEditbutton.click();
		validateNew(Emailform);
		validateNew(email);
		System.out.println(email.getText());
	}

	public void validateAccountEdit(String password2) throws InterruptedException {

		EditLink.click();
		CurrentPassword.sendKeys(password2);
		NewPassword.sendKeys(Password + "@4");
		ConfirmPassword.sendKeys(Password + "@4");
		SaveButton.click();
		wait(20000);
		Assert.assertTrue("Button displayed",Password.isDisplayed());

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
		Assert.assertTrue("Button displayed",Password.isDisplayed());
		
	}
	
	public boolean validateSavebuttonclick() {

		SaveButton.click();
		if(passworderrormessage.getText().contentEquals("This field is required."))
				{
			System.out.println("The element" + passworderrormessage.getText() + "is found");
            return true;
			}
			else
			{
            Assert.fail("The element " + passworderrormessage.getText() + "is not found");
            }
			return false;
			}


	
	public void validateseemorewaystext()
	{
	validate(Seemorewaystext);
	}
	
	public ContactUsPage clickcontactUslink()
	{
    validate(contactUs);
    contactUs.click();
    if(getTitle().equalsIgnoreCase("AARP Medicare Plans | Contact Us"))
	{
		return new ContactUsPage(driver);
	}
	return null;
	}
	
	public void validateneedhelpheader()
	{
		validate(NeedHelpHeader);
		validate(Technicalsupportsection);
		validate(PlanSupportsection);
	}
	
	
	
	
	public void clickOndisclaimerlink(JSONObject myProfilenpreferencesexpectedjson) {
		// TODO Auto-generated method stub

		Disclaimerlink.click();
		// Thread.sleep(15000);
		String finalPath;
		String table_data;

		// validate(disclaimertextarea_xpath);
		try {
			finalPath = Disclaimerlinkcontent_xpath + "/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("1stline"),
			table_data);
			// to validate amount Billed
			finalPath = Disclaimerlinkcontent_xpath + "/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("2ndline"), table_data);
			// to validate amount Paid
			finalPath = Disclaimerlinkcontent_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("3rdline"), table_data);
			// to validate paid Date
			finalPath = Disclaimerlinkcontent_xpath + "/p[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(myProfilenpreferencesexpectedjson.get("4thline"), table_data);
			
			Disclaimerlink.click();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void validatepermanentaddress()
	{
		validate(permanentaddress);
		
	}
	
	public boolean validatecontactuslink()
	{
		validate(contactuslink);
		contactuslink.click();
		
		    if(driver.getCurrentUrl().contains("team-d-aarpmedicareplans.uhc.com/home/contact-us.html"))
			{
		    	return true;
			}
			else
			{
            Assert.fail("The element " + contactuslink.getText() + "is not found");
            }
			return false;
			}
	

	public void validatePhoneElements() {

		validateNew(PhoneHeader);
		validateNew(PhoneEditButton);
		// validateNew(PhoneEditLink);
		validateNew(Daytimephone);
		validateNew(EveningPhone);

	}

	public void validatePhoneEditElements() {
		PhoneEditButton.click();
		validateNew(EveningTimePhoneTextField);
		validateNew(DaytimePhoneTextField);
		validateNew(PhoneTopCancelButton);
		validateNew(PhoneCancelButton);
		validateNew(PhoneSaveButton);
	}

	public void validatePhoneCancel() {
		if (PhoneCancelButton.isDisplayed()) {
			// PhoneEditButton.click();
			PhoneCancelButton.click();

			if (EveningTimePhoneTextField.isDisplayed()) {

				Assert.fail();
			}

		}

	}

	public void validatePhoneSave() {
		if (PhoneSaveButton.isDisplayed()) {
			String evetime = "1111111111";
			String daytime = "2222222222";
			EveningTimePhoneTextField.clear();
			DaytimePhoneTextField.clear();
			EveningTimePhoneTextField.sendKeys(evetime);
			DaytimePhoneTextField.sendKeys(daytime);
			PhoneSaveButton.click();

			Assert.assertTrue(eveningPhoneValue.getText().equalsIgnoreCase(evetime)
					&& DaytimePhoneValue.getText().equalsIgnoreCase(daytime));
		}

	}

	public void validateCancelElement() {
		// TODO Auto-generated method stub
		Assert.assertTrue(PhoneTopCancelButton.getText().equalsIgnoreCase("CANCEL"));

	}
	
	
	
}
	
	
	


