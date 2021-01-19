package pages.regression.pharmaciesandprescriptions;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingAddressPage extends ShippingAddressWebElements {

	public ShippingAddressPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnChangeShippingAddress() {
		changeShippingAddressCTA.click();
	}

	public boolean validateShippingPageHeader(String expectedVal, int index) {
		return shippingPageHeader.get(index).getText().equalsIgnoreCase(expectedVal);
	}

	public String selectRadioBtnAndfetchSelectedAddress() {
		String addressForSelectdRadioBtn;
		Random rand = new Random();
		int rand_int = rand.nextInt(listOfRadioBtnNotSelected.size());
		addressForSelectdRadioBtn = listOfAddressOfNotSelectedRadioBtn.get(rand_int).getText();
		System.out.println(addressForSelectdRadioBtn);
		listOfRadioBtnNotSelected.get(rand_int).click();
		return addressForSelectdRadioBtn;
	}

	public void clickOnUseThisAddressCTA() {
		useThisAddressBtn.click();
	}

	public String clickOnEditLinkAndfetchtheAddressVal() {
		String editableAddressVal;
		Random rand = new Random();
		int rand_int = rand.nextInt(listOfEditAddressLink.size());
		editableAddressVal = listOfEditableAddress.get(rand_int).getText();
		listOfEditAddressLink.get(rand_int).click();
		return editableAddressVal;
	}

	public void enterTextInAddressLine1Field(String valueToBeEntered) {
		addressLine1Field.sendKeys(valueToBeEntered);
	}

	public boolean validateAddressEnteredInAddressLine1Field(String valueToVerify) {
		return addressLine1Field.getAttribute("value").contains(valueToVerify);
	}

	public void clickOnAddressLine2Link() {
		addAddressLine2Link.click();
	}

	public boolean validateAddressLine2Field() {
		return validate(addressLine2Field, 10);
	}

	public boolean validateAddressLine2LinkNtAvailable() {
		return listOfAddressLine2Link.size() == 0;
	}

	public boolean validateAddressEnteredInAddressLine2Field(String valueToVerify) {
		return addressLine2Field.getAttribute("value").contains(valueToVerify);
	}

	public void enterTextInAddressLine2Field(String valueToEnter) {
		addressLine2Field.sendKeys(valueToEnter);
	}

	public void clickOnXIcon() {
		crossIconBtn.click();
	}

	public void clickOnCancelCTA() {
		cancelAddress.click();
	}

	public void clickOnSaveAndContinueCTA() {
		saveAndContinueBtn.click();
	}

	public void clickOnAddAddressCTA() {
		addAddressBtn.click();
	}

	public void clickOnMakePreferedCheckBox() {
		// jsClickNew(makePreferredAddressCheckBox);
		makePreferredAddressCheckBox.click();
	}

	public String selectAnAddressWhichIsNotPreferedAndfetchAddressDetails() {
		String addressDetails;
		String radioVal = radioBtnHavingPreferedAddress.getAttribute("data-testid");
		System.out.println(radioVal);
		String[] arrayVal = radioVal.split("__");
		System.out.println(arrayVal[0] + arrayVal[1]);
		addressDetails = listOfAddress.get(Integer.parseInt(arrayVal[1] + 1)).getText();
		listOfShipToRadioBtn.get(Integer.parseInt(arrayVal[1] + 1)).click();
		// clickOnMakePreferedCheckBox();
		return addressDetails;
	}

	public boolean validateMakeMyPreferedAddressCheckBox(String expectedVal) {
		return makePreferredAddressCheckBox.getAttribute("type").equals("checkbox")
				&& makePreferredAddressCheckBox.getAttribute("aria-label").equalsIgnoreCase(expectedVal);
	}

	public void enterTextInCityField(String cityValue) {
		cityInputField.sendKeys(cityValue);
	}

	public void enterZipCodeInZipCodeField(String zipCode) {
		zipInputField.sendKeys(zipCode);
	}

	public void selectState(String expectedState) {
		stateInputField.click();
		for (WebElement ele : listOfState) {
			if (ele.getText().equals(expectedState)) {
				scrollToView(ele);
				ele.click();
				break;
			}
		}
	}

	public boolean validateAddressNotAdded(int expectdCount) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(expectdCount);
		System.out.println(listOfAddress.size());
		return listOfAddress.size() == expectdCount;
	}

	public int countOfAddressOnChangeShippingPage() {
		return listOfAddress.size();
	}

	public boolean validateSuccessMessageAfterSavingAndEditingAddress(String expectedVal) {
		return validate(successMessage, 30) && successMessage.getText().contains(expectedVal);
	}

	public int getIndexValOfNewAddressAdded(String expectedVal) {
		int index = 0;
		System.out.println(expectedVal);
		for (int i = 0; i < listOfEditableAddress.size(); i++) {
			System.out.println(listOfEditableAddress.get(i).getText());
			if (listOfEditableAddress.get(i).getText().contains(expectedVal.toUpperCase())) {
				index = i;
			}
		}
		System.out.println();
		return index;
	}

	public String clickOnEditLinkBasedOnIndex(int indexVal) {
		String editableAddressVal;
		editableAddressVal= listOfEditableAddress.get(indexVal).getText();
		listOfEditAddressLink.get(indexVal).click();
		return editableAddressVal;
	}

	public String getAddressValBasedOnIndex(int indexVal) {
		return listOfEditableAddress.get(indexVal).getText();
	}

	public boolean validateDeleteConfirmMessage() {
		return validate(deleteConfirmMessage, 20);
	}

	public void clickOnYesDeleteConfirmation() {
		deleteConfirmYesCTA.click();
	}

	public void clickOnDeleteThisAddressCTA() {
		deleteAddressCTA.click();
	}

	public boolean validateDeletedAddressNotAppearing(String deletedAddressLine1) {
		for (WebElement ele : listOfAddress) {
			if (ele.getText().contains(deletedAddressLine1)) {
				return false;
			}
		}
		return true;
	}

}
