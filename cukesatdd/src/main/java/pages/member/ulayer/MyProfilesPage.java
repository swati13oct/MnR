package pages.member.ulayer;

/*@pagarwa5*/

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MyProfilesPage extends UhcDriver{
	
   @FindBy(className = "shipmyplans_tab")
   private WebElement myProfilesTab;
   
   @FindBy(className = "shipmyprefers_tab")
   private WebElement myPrefTab;
   
   @FindBy(id = "currentPasswordVerify")
	private WebElement currentPasswordField;
	
	@FindBy(id = "countrySelect")
	private WebElement selectCountry;
	
	@FindBy(id = "stateSelect")
	private WebElement selectState;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "passwordVerify")
	private WebElement passwordVerifyField;

	@FindBy(xpath = "//div[@class='overflowprofile']/div[3]/div[2]/ul/li[2]/input")
	private WebElement emailField;

	@FindBy(xpath = "//div[@class='overflowprofile']/div[3]/div[2]/ul/li[4]/input")
	private WebElement emailVerifyField;
	
	@FindBy(xpath = "//form[@id='editProfileForm']/div[2]/div[2]/div[3]/div[2]/div[1]/a")
	private WebElement planProfileEditLink;
	
	@FindBy(xpath = "//form[@id='editProfileForm']/div[2]/div[2]/div[4]/div[2]/div[1]/a")
	private WebElement alternateAddressEditLink;

	@FindBy(xpath = "//div[@class='editLink']")
	private List<WebElement> editLink;

	@FindBy(xpath = "//div[@class='accProMidBg']")
	private WebElement accountInfo;

	@FindBy(linkText = "save")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='myProSubCntMidBg']")
	private WebElement planProfileInfo;

	@FindBy(id = "temporaryAddress.addressLine1")
	private WebElement tempAddress1Field;
	
	@FindBy(id = "temporaryAddress.addressLine2")
	private WebElement tempAddress2Field;
	
	@FindBy(id = "temporaryAddress.city")
	private WebElement cityField;
	
	@FindBy(id = "temporaryAddress.zipCode")
	private WebElement zipCodeField;
	
	@FindBy(id = "temporaryAddress.startDate.month")
	private WebElement tempAddStartDateMonthField;
	
	@FindBy(id = "temporaryAddress.startDate.day")
	private WebElement tempAddStartDateDayField;
	
	@FindBy(id = "temporaryAddress.startDate.year")
	private WebElement tempAddStartDateYearField;
	
	@FindBy(id = "temporaryAddress.stopDate.month")
	private WebElement tempAddStopDateMonthField;
	
	@FindBy(id = "temporaryAddress.stopDate.day")
	private WebElement tempAddStopDateDayField;
	
	@FindBy(id = "temporaryAddress.stopDate.year")
	private WebElement tempAddStopDateYearField;
	
	@FindBy(id = "permanentAddress.addressLine1")
	private WebElement addressLine1Field;
	
	@FindBy(id = "permanentAddress.addressLine2")
	private WebElement addressLine2Field;
	
	@FindBy(id = "dayPhone.areaCode")
	private WebElement areaCodeField;
	
	@FindBy(id = "dayPhone.numberPrefix")
	private WebElement numberPrefixField;
	
	@FindBy(id = "dayPhone.number")
	private WebElement numberField;
	
	@FindBy(id = "eveningPhone.areaCode")
	private WebElement areaCodeEveningField;
	
	@FindBy(id = "eveningPhone.numberPrefix")
	private WebElement numberPrefixEveningField;
	
	@FindBy(id = "eveningPhone.number")
	private WebElement numberEveningField;
	
	@FindBy(css = "div.accountProfile.margin_bot_5px > div.accProMidBg > div.editLink > a")
	private WebElement mailingAddressEditLink;
	
	@FindBy(id = "mailingAddress.addressLine1")
	private WebElement mailingAddress1;
	
	@FindBy(id = "mailingAddress.city")
	private WebElement mailingAddresscity;
	
	@FindBy(id = "mailingAddress.addressLine2")
	private WebElement mailingAddress2;
	
	@FindBy(id = "mailingAddress.zipCode")
	private WebElement mailingAddZip;
	
	@FindBy(id = "mailingAddress.startDate.month")
	private WebElement mailingAddStartDateMonth;
	
	@FindBy(id = "mailingAddress.startDate.day")
	private WebElement mailingAddStartDateDay;
	
	@FindBy(id = "mailingAddress.startDate.year")
	private WebElement mailingAddStartDateYear;
	
	@FindBy(id = "mailingAddress.stopDate.month")
	private WebElement mailingAddStopDateMonth;
	
	@FindBy(id = "mailingAddress.stopDate.day")
	private WebElement mailingAddStopDateDay;
	
	@FindBy(id = "mailingAddress.stopDate.year")
	private WebElement mailingAddStopDateYear;
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	private PageData myProfiles;

	public JSONObject myProfilesJson;

	public MyProfilesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		myProfiles = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public MyPreferencesPage navigateToMyPrefTab() {
		myPrefTab.click();
		if(currentUrl().contains("my-preferences"))
		{
			return new MyPreferencesPage(driver);
		}
		return null;
	}
	
	public void logOut() {
		logOut.click();

	}	
	
	public String getAccountInfo() {
		return accountInfo.getText();

	}

	public String getPlanProfileInfo() {
		return planProfileInfo.getText();
	}

	public void editProfile(Map<String, String> profileAttributesMap) {
		WebElement accountInfoElement = editLink.get(0);
		accountInfoElement.findElement(By.linkText("Edit")).click();
		currentPasswordField.click();
		currentPasswordField.clear();
		currentPasswordField.sendKeys(profileAttributesMap
				.get("Current password"));
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(profileAttributesMap.get("New password"));
		passwordVerifyField.click();
		passwordVerifyField.clear();
		passwordVerifyField.sendKeys(profileAttributesMap
				.get("Confirm password"));
		emailField.click();
		emailField.clear();
		emailField.sendKeys(profileAttributesMap.get("New email address"));
		emailVerifyField.click();
		emailVerifyField.clear();
		emailVerifyField.sendKeys(profileAttributesMap
				.get("Confirm email address"));
		saveButton.click();
		System.out.println("accountEdited");

	}

	public void editPlanProfile(Map<String, String> profileAttributesMap) {
		planProfileEditLink.click();
		addressLine1Field.click();
		addressLine1Field.clear();
		addressLine1Field.sendKeys(profileAttributesMap.get("Street address"));
		addressLine2Field.click();
		addressLine2Field.clear();
		addressLine2Field.sendKeys(profileAttributesMap.get("Street address2"));		
		areaCodeField.click();
		areaCodeField.clear();
		areaCodeField.sendKeys(profileAttributesMap.get("Daytime phone").split("-")[0]);
		numberPrefixField.click();
		numberPrefixField.clear();
		numberPrefixField.sendKeys(profileAttributesMap.get("Daytime phone").split("-")[1]);
		numberField.click();
		numberField.clear();
		numberField.sendKeys(profileAttributesMap.get("Daytime phone").split("-")[2]);
		areaCodeEveningField.click();
		areaCodeEveningField.clear();
		areaCodeEveningField.sendKeys(profileAttributesMap.get("Evening phone").split("-")[0]);
		numberPrefixEveningField.click();
		numberPrefixEveningField.clear();
		numberPrefixEveningField.sendKeys(profileAttributesMap.get("Evening phone").split("-")[1]);
		numberEveningField.click();
		numberEveningField.clear();
		numberEveningField.sendKeys(profileAttributesMap.get("Evening phone").split("-")[2]);
		saveButton.click();
	}

	public void editAlternateAddress(Map<String, String> profileAttributesMap) {
		alternateAddressEditLink.click();
		tempAddress1Field.click();
		tempAddress1Field.clear();
		tempAddress1Field.sendKeys(profileAttributesMap.get("Street address"));
		tempAddress2Field.click();
		tempAddress2Field.clear();
		tempAddress2Field.sendKeys(profileAttributesMap.get("Street address2"));
		cityField.click();
		cityField.clear();
		cityField.sendKeys(profileAttributesMap.get("City"));
		selectState.click();
		selectState.sendKeys(profileAttributesMap.get("State"));
		zipCodeField.click();
		zipCodeField.clear();
		zipCodeField.sendKeys(profileAttributesMap.get("Zip Code"));
		selectCountry.click();
		selectCountry.sendKeys(profileAttributesMap.get("Country"));
		/*String countryXPath = "countrySelect/*[. = '"+profileAttributesMap.get("Country")+"']";
		WebElement countryElement = driver.findElement(By.xpath(countryXPath));
		if (!countryElement.isSelected()) {
			countryElement.click();
        }*/
		tempAddStartDateMonthField.clear();
		tempAddStartDateMonthField.clear();
		tempAddStartDateMonthField.sendKeys(profileAttributesMap.get("Start Date").split("-")[0]);
		tempAddStopDateDayField.clear();
		tempAddStopDateDayField.clear();
		tempAddStopDateDayField.sendKeys(profileAttributesMap.get("Start Date").split("-")[1]);
		tempAddStopDateYearField.clear();
		tempAddStopDateYearField.clear();
		tempAddStopDateYearField.sendKeys(profileAttributesMap.get("Start Date").split("-")[2]);
		tempAddStopDateMonthField.clear();
		tempAddStopDateMonthField.clear();
		tempAddStopDateMonthField.sendKeys(profileAttributesMap.get("End Date").split("-")[0]);
		tempAddStopDateDayField.clear();
		tempAddStopDateDayField.clear();
		tempAddStopDateDayField.sendKeys(profileAttributesMap.get("End Date").split("-")[1]);
		tempAddStopDateYearField.clear();
		tempAddStopDateYearField.clear();
		tempAddStopDateYearField.sendKeys(profileAttributesMap.get("End Date").split("-")[2]);
		saveButton.click();
	}

	public void editMailingAddress(Map<String, String> profileAttributesMap) {

		mailingAddressEditLink.click();
		mailingAddress1.click();
		mailingAddress1.clear();
		mailingAddress1.sendKeys(profileAttributesMap.get("Street address"));
		mailingAddress2.click();
		mailingAddress2.clear();
		mailingAddress2.sendKeys(profileAttributesMap.get("Street address2"));
		mailingAddresscity.click();
		mailingAddresscity.clear();
		mailingAddresscity.sendKeys(profileAttributesMap.get("City"));
		/*String stateXPath = "stateSelect/*[. = '"+profileAttributesMap.get("State")+"']";
		WebElement stateElement  = driver.findElement(By.xpath(stateXPath));
		if (!stateElement.isSelected()) {
			stateElement.click();
        }*/
		selectState.click();
		selectState.sendKeys(profileAttributesMap.get("State"));
		mailingAddZip.click();
		mailingAddZip.clear();
		mailingAddZip.sendKeys(profileAttributesMap.get("Zip Code"));
		/*String countryXPath = "countrySelect/*[. = '"+profileAttributesMap.get("Country")+"']";
		WebElement countryElement = driver.findElement(By.xpath(countryXPath));
		if (!countryElement.isSelected()) {
			countryElement.click();
        }*/
		
		selectCountry.click();
		selectCountry.sendKeys(profileAttributesMap.get("Country"));
		mailingAddStartDateMonth.clear();
		mailingAddStartDateMonth.clear();
		mailingAddStartDateMonth.sendKeys(profileAttributesMap.get("Start Date").split("-")[0]);
		mailingAddStartDateDay.clear();
		mailingAddStartDateDay.clear();
		mailingAddStartDateDay.sendKeys(profileAttributesMap.get("Start Date").split("-")[1]);
		mailingAddStartDateYear.clear();
		mailingAddStartDateYear.clear();
		mailingAddStartDateYear.sendKeys(profileAttributesMap.get("Start Date").split("-")[2]);
		mailingAddStopDateMonth.clear();
		mailingAddStopDateMonth.clear();
		mailingAddStopDateMonth.sendKeys(profileAttributesMap.get("End Date").split("-")[0]);
		mailingAddStopDateDay.clear();
		mailingAddStopDateDay.clear();
		mailingAddStopDateDay.sendKeys(profileAttributesMap.get("End Date").split("-")[1]);
		mailingAddStopDateYear.clear();
		mailingAddStopDateYear.clear();
		mailingAddStopDateYear.sendKeys(profileAttributesMap.get("End Date").split("-")[2]);
		saveButton.click();		
	}


	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : myProfiles.getExpectedData().keySet()) {
			WebElement element = findElement(myProfiles.getExpectedData()
					.get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		myProfilesJson = jsonObject;
		
	}


	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesPageExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PROFILES);
		myProfilesPageExpectedJson = CommonUtility.mergeJson(
				myProfilesPageExpectedJson, globalExpectedJson);
		return myProfilesPageExpectedJson;
	}


}
