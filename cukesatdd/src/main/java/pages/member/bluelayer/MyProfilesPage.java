package pages.member.bluelayer;

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

public class MyProfilesPage extends UhcDriver {

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

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData myProfiles;

	public JSONObject myProfilesJson;

	public MyProfilesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		myProfiles = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public MyPrefPage selectMyPref() {
		myPrefTab.click();
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Go Green")) {
			return new MyPrefPage(driver);
		} else {
			return null;
		}
	}

	public void editProfile(Map<String, String> profileAttributesMap) {
		WebElement accountInfoElement = editLink.get(0);
		accountInfoElement.findElement(By.linkText("Edit")).click();
		sendkeys(currentPasswordField,
				profileAttributesMap.get("Current password"));
		sendkeys(passwordField, profileAttributesMap.get("New password"));
		sendkeys(passwordVerifyField,
				profileAttributesMap.get("Confirm password"));
		sendkeys(emailField, profileAttributesMap.get("New email address"));
		sendkeys(emailVerifyField,
				profileAttributesMap.get("Confirm email address"));
		saveButton.click();
		System.out.println("accountEdited");

	}

	public void editPlanProfile(Map<String, String> profileAttributesMap) {
		planProfileEditLink.click();
		sendkeys(addressLine1Field, profileAttributesMap.get("Street address"));
		sendkeys(addressLine2Field, profileAttributesMap.get("Street address2"));
		sendkeys(areaCodeField, profileAttributesMap.get("Daytime phone")
				.split("-")[0]);
		sendkeys(numberPrefixField, profileAttributesMap.get("Daytime phone")
				.split("-")[1]);
		sendkeys(numberField,
				profileAttributesMap.get("Daytime phone").split("-")[2]);
		sendkeys(areaCodeEveningField, profileAttributesMap
				.get("Evening phone").split("-")[0]);
		sendkeys(numberPrefixEveningField,
				profileAttributesMap.get("Evening phone").split("-")[1]);
		sendkeys(numberEveningField, profileAttributesMap.get("Evening phone")
				.split("-")[2]);
		saveButton.click();
	}

	public void editAlternateAddress(Map<String, String> profileAttributesMap) {
		alternateAddressEditLink.click();
		sendkeys(tempAddress1Field, profileAttributesMap.get("Street address"));
		sendkeys(tempAddress2Field, profileAttributesMap.get("Street address2"));
		sendkeys(cityField, profileAttributesMap.get("City"));
		sendkeys(tempAddress1Field, profileAttributesMap.get("Street address"));
		select(selectState, profileAttributesMap.get("State"));
		sendkeys(zipCodeField, profileAttributesMap.get("Zip Code"));
		select(selectCountry, profileAttributesMap.get("Country"));
		sendkeys(tempAddStartDateMonthField,
				profileAttributesMap.get("Start Date").split("-")[0]);
		sendkeys(tempAddStopDateDayField, profileAttributesMap
				.get("Start Date").split("-")[1]);
		sendkeys(tempAddStopDateYearField,
				profileAttributesMap.get("Start Date").split("-")[2]);
		sendkeys(tempAddStopDateMonthField, profileAttributesMap
				.get("End Date").split("-")[0]);
		sendkeys(tempAddStopDateDayField, profileAttributesMap.get("End Date")
				.split("-")[1]);
		sendkeys(tempAddStopDateYearField, profileAttributesMap.get("End Date")
				.split("-")[2]);
		saveButton.click();
	}

	public void editMailingAddress(Map<String, String> profileAttributesMap) {

		mailingAddressEditLink.click();
		sendkeys(mailingAddress1, profileAttributesMap.get("Street address"));
		sendkeys(mailingAddress2, profileAttributesMap.get("Street address2"));
		sendkeys(mailingAddresscity, profileAttributesMap.get("City"));
		select(selectState, profileAttributesMap.get("State"));
		sendkeys(mailingAddZip, profileAttributesMap.get("Zip Code"));
		select(selectCountry, profileAttributesMap.get("Country"));
		sendkeys(mailingAddStartDateMonth,
				profileAttributesMap.get("Start Date").split("-")[0]);
		sendkeys(mailingAddStartDateDay, profileAttributesMap.get("Start Date")
				.split("-")[1]);
		sendkeys(mailingAddStartDateYear, profileAttributesMap
				.get("Start Date").split("-")[2]);
		sendkeys(mailingAddStopDateMonth, profileAttributesMap.get("End Date")
				.split("-")[0]);
		sendkeys(mailingAddStopDateDay, profileAttributesMap.get("End Date")
				.split("-")[1]);
		sendkeys(mailingAddStopDateYear, profileAttributesMap.get("End Date")
				.split("-")[2]);
		saveButton.click();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap, boolean isUpdate) {

		/* get MY PROFILES expected data */

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesExpectedJson = expectedDataMap
				.get(isUpdate?CommonConstants.MY_PROFILES_AFTER_UPDATE:CommonConstants.MY_PROFILES_BEFORE_UPDATE);
		myProfilesExpectedJson = CommonUtility.mergeJson(
				myProfilesExpectedJson, globalExpectedJson);

		return myProfilesExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(myPrefTab);
		JSONObject jsonObject = new JSONObject();
		for (String key : myProfiles.getExpectedData().keySet()) {
			WebElement element = findElement(myProfiles.getExpectedData().get(
					key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		myProfilesJson = jsonObject;
		
		System.out.println("myProfilesJson----->"+myProfilesJson);

	}

	public void logOut() {
		logOut.click();
	}

}
